package com.mengfou.service.impl;

import com.mengfou.config.download.DownloadPathConfig;
import com.mengfou.dao.LeaderBoardMapper;
import com.mengfou.entity.ConstValue;
import com.mengfou.entity.LeaderBoard;
import com.mengfou.entity.ServerResponse;
import com.mengfou.exceptions.DownloadResultException;
import com.mengfou.service.IDownloadNovelImageService;
import com.mengfou.utils.MD5;
import com.mengfou.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 梦否
 * @date 2022/05/06 10:45
 * 出于效率考虑，可以使用多线程下载，这里就不弄了。
 */
@Service("iDownloadNovelImageService")
public class DownloadNovelImageServiceImpl implements IDownloadNovelImageService {

    private static final Logger logger = LoggerFactory.getLogger(DownloadNovelImageServiceImpl.class);
    private int item = 0;
    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(0,
            Runtime.getRuntime().availableProcessors() + 1,
            10L,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>()
    );
    private CountDownLatch countDownLatch = null;

    @Autowired
    LeaderBoardMapper leaderBoardMapper;

    @Autowired
    DownloadPathConfig downloadPathConfig;

    @Override
    public void startDownloadImages() {
        int start = 1, limit = 20;
        item = 1;
        int size = leaderBoardMapper.getNovelIds().size();
        countDownLatch = new CountDownLatch(size);
        logger.info("需要等待下载" + size + "条图片数据。");
        int pages = (size / limit) + 1;
        while (start <= pages) {
            List<LeaderBoard> leaderBoards = leaderBoardMapper.selectByTurnPage((start - 1) * limit, limit);
            for (LeaderBoard leaderBoard : leaderBoards) {
                logger.info("下载: " + leaderBoard.getId() + " " + (item++) + "条。");
                startDownloadImageById(item, leaderBoard);
            }
            start++;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startDownloadImageById(int index, LeaderBoard leaderBoards) {
        executor.execute(new MyDownloader()
                .setPicURL(leaderBoards.getPicurl())
                .setNumber(index)
                .setNovelId(leaderBoards.getId())
        );
    }

    @Override
    public ServerResponse<String> startDownloadImageById(String bid) {
        String picURL = leaderBoardMapper.selectByPrimaryKey(bid).getPicurl();
        MyDownloader task = new MyDownloader();
        task.setPicURL(picURL);
        executor.execute(task);
        return ServerResponse.createBySuccess("图片下载完毕！");
    }


    class MyDownloader implements Runnable {

        private String picURL = null;
        private String novelId = null;
        private int number = 0;

        public MyDownloader setPicURL(String picURL) {
            this.picURL = picURL;
            return this;
        }

        public MyDownloader setNovelId(String novelId) {
            this.novelId = novelId;
            return this;
        }

        public MyDownloader setNumber(int index) {
            this.number = index;
            return this;
        }

        @Override
        public void run() {
            if (picURL != null) {
                try {
                    downloadImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void downloadImage() throws IOException {
            HttpURLConnection connection = null;
            RandomAccessFile randomAccessFile = null;
            InputStream inputStream = null;
            URL url = new URL(ConstValue.baseURL + picURL);
            try {
                String md5filename = MD5.MD5EncodeUtf8(picURL);
                File localFile = new File(downloadPathConfig.getFilePath() + md5filename + ".jpg");
                // 判断是否存在
                if (localFile.exists()) {
                    logger.info("第" + this.number + "条图片本地存在，跳过下载！ID: " + novelId + " FileMd5: " + md5filename);
                    return;
                }
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(500); // 500毫秒
                connection.setRequestMethod("GET"); // get请求
                connection.setRequestProperty("Charset", "UTF-8");
                connection.setRequestProperty("accept", "*/*");

                inputStream = connection.getInputStream();
                if (connection.getResponseCode() == 200) {
                    randomAccessFile = new RandomAccessFile(localFile, "rwd");
                    byte[] buffer = new byte[2048];
                    int len = -1;
                    while ((len = inputStream.read(buffer)) != -1) {
                        randomAccessFile.write(buffer, 0, len);
                    }
                    logger.info("第" + this.number + "条图片下载完成！");
                } else {
                    throw new DownloadResultException("下载图片错误：响应了数据，但响应码为：" + connection.getResponseCode());
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("第" + this.number + "条图片下载发生了异常！" + e.getMessage());
            } finally {
                try {
                    if (inputStream != null) inputStream.close();
                    if (randomAccessFile != null) randomAccessFile.close();
                    if (connection != null) connection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info("第" + this.number + "条图片下载发生了异常！" + e.getMessage());
                }
                countDownLatch.countDown();
            }
        }
    }
}
