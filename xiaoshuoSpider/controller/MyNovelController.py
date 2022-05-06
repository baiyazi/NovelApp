"""
    @Date: 2022/5/4
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  爬取内容：
        全部作品：http://47.106.243.172:8888/book/bookclass.html
            只爬取男频下的如下分类（按分类爬取）：
                - 玄幻奇幻
                - 武侠仙侠
                - 都市言情
                - 历史军事
                - 科幻灵异
                - 网游竞技
        排行榜：http://47.106.243.172:8888/book/book_ranking.html
            按排行榜爬取
"""
from service import MyDataBaseService, CrawlByCategoryService, CrawlByLeaderboardService, CrawlDetailInfoService
from entity.NovelCategory import Category


class MyController(object):

    def __init__(self):
        pass

    def crawlByCategory(self, category: Category):
        return CrawlByCategoryService.startCrawlerByCategory(category)

    def crawlByCategories(self):
        datas = []
        for category in Category:
            data = self.crawlByCategory(category)
            if data is not None:
                datas.append(data)
        return datas

    def crawlByLeaderboard(self):
        return CrawlByLeaderboardService.startCrawlByLeaderboard()

    def startCrawl(self):
        return self.crawlByCategories() + self.crawlByLeaderboard()


def beginCrawler():
    list_datas = MyController().startCrawl()
    MyDataBaseService.save_datas(list_datas)
    CrawlDetailInfoService.parseAndLoad(list_datas)
