# 1. 前言

该项目为小说`App`的后台服务程序，采用`SpringBoot`来搭建。逻辑上来说比较简单，主要是完成对爬虫保存在`MySQL`数据库中的数据获取。因为业务上来说只需要查询功能，故而仅包含下面几种功能操作：

* 分页查询所有小说简略数据；
* 查询具体条目信息；
* 加载每个章节的内容；

# 2. 完成接口

| 功能                                                   | 接口                              | 说明                                                         | 完成标记           |
| ------------------------------------------------------ | --------------------------------- | ------------------------------------------------------------ | ------------------ |
| 分页查询简略数据                                       | `/book/{currentPage}?limit`       | `currentPage`为当前第几页，编号从`1`开始；`limit`为每页多少条数据； | :white_check_mark: |
| 根据小说`id`查询简略数据                               | `/book/{bid}`                     | `bid`为小说的`id`，类型为字符串；                            | :white_check_mark: |
| 查询数据库中已经爬取到章节的所有小说`id`               | `/book/vaild/list`                |                                                              | :white_check_mark: |
| 查询数据库中爬取到的小说`id`，可能章节未获取到         | `/book/list`                      |                                                              | :white_check_mark: |
| 查询某个小说的某章内容                                 | `/book/{bid}/section/{sid}`       | `bid`为小说的`id`，类型为字符串；`sid`为章节的标识，类型为`int`，编号从`1`开始； | :white_check_mark: |
| 查询数据库中某个小说有多少章                           | `/book/{bid}/section/list`        | `bid`为小说的`id`，类型为字符串；                            | :white_check_mark: |
| 查询已下载有章节的小说（这里叫做：有效数据）的类别数据 | `/book/vaild/category`            |                                                              | :white_check_mark: |
| 获取有效数据下的对应类别的所有数据                     | `/book/vaild/category/{category}` | `category`即数据库中对应的`catName`，比如：玄幻奇幻。        | :white_check_mark: |

# 3. 图片下载

注意到：在爬虫程序中没有处理图片下载问题。接下来在`Java`程序中进行图片的下载和对应的链接保存。

| 功能                                                         | 接口                                                         | 说明                                                         | 标记                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ----------------------- |
| 下载数据库中所有存储的小说简略信息的封面图片                 | [localhost:9090/image/download](http://localhost:9090/image/download) |                                                              | :ballot_box_with_check: |
| 获取数据库中所有小说对应的本地封面图片                       | [localhost:9090/image/url](http://localhost:9090/image/url)  |                                                              | :ballot_box_with_check: |
| 根据小说的`bid`来下载对应的封面图片                          | [localhost:9090/image/download/{bid}](http://localhost:9090/image/download/{bid}) |                                                              | :ballot_box_with_check: |
| 显示图片（确保服务器已经调用过了`localhost:9090/image/download`方法进行下载） | 直接访问图片静态资源：`localhost:9090/image/{md5}.jpg`       | `md5`值的计算根据数据库中的图片地址来进行计算的，加入了额外的固定字符串，以防止解密。但这里只是为了做关系映射。 | :ballot_box_with_check: |
| 显示图片，因为一般不知道图片的`md5`值，所以提供了由图片的`bid`获取图片资源的接口 | `localhost:9090/image/load/{bid}`                            | 这个方法中判断图片在服务器端是否存在，如果不存在会进源网站下载，否则转发到静态资源路径。 | :ballot_box_with_check: |

# 4. 配置说明

```yaml
localimage:  
	file-path: D:/novelimage/  
	access-path: /image/**
```

这里配置的是图片的存储路径。下面方法虽然可以做到不存在就从源网站下载，但是需要调用两次才能完成加载：

```java
@RequestMapping(value = "load/{bid}", method = RequestMethod.GET)
public String doLoadImage(@PathVariable("bid") String bid) {    
    logger.info("开始加载图片数据！");    
    LeaderBoard leaderBoard = iLeaderBoradService.getLeaderBoardById(bid);    String md5 = MD5.MD5EncodeUtf8(leaderBoard.getPicurl());    
    File file = new File(downloadPathConfig.getFilePath() + md5 + ".jpg");    
    if (!file.exists()) return "forward:/image/downloaded/" + bid + "?md5=" + md5;    
    return "forward:/image/" + md5 + ".jpg";
}
```

之后再解决。因为这里直接使用http://localhost:9090/image/download接口可以下载所有图片到服务器，上面这个接口用处也不大，就不解决了。



