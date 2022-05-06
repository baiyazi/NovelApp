"""
    @Date: 2022/5/4
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  
"""
from entity.NovelCategory import Category
from entity.RequestType import RequestType
from exceptions.MyException import ErrorRequestTypeException
from model import MyCrawlerModel
from entity.ConstValue import baseURL


def startCrawlerByCategory(category: Category):
    data = CrawlByLeaderboard().doRequest(category)
    return data


class CrawlByLeaderboard(MyCrawlerModel.Model):

    def __init__(self):
        MyCrawlerModel.Model.__init__(self)
        self.baseURL = "{0}/book/searchByPage?curr={1}&limit={2}&keyword=&workDirection=0&catId={3}"
        self.type = RequestType.JSON
        self.currentPage = 1
        self.base = baseURL

    def getURL(self, category: Category, limit=200):
        return self.baseURL.format(self.base, self.currentPage, limit, category.value)

    def doRequest(self, category: Category, limit=200):
        if self.type == RequestType.JSON:
            json_data = self.requestJson(self.getURL(category, limit))
            return json_data
        else:
            raise ErrorRequestTypeException("错误的请求类型[JSON/PAGE].")

# if __name__ == '__main__':
#     startCrawlerByCategory(Category.KEHUAN)
