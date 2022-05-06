"""
    @Date: 2022/5/4
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:
    http://47.106.243.172:8888/book/listRank?type=0&limit=30
    `tpye`表示排行榜类型：
    `0`表示点击榜、
    `1`表示新书榜、
    `2`表示更新榜、
    `3`表示评论榜；
    `limit`表示每页加载多少条数据；
"""
from entity.ConstValue import baseURL
from entity.CrawlByLeaderboardParameterType import ParameterType
from exceptions.MyException import ErrorRequestTypeException
from model import MyCrawlerModel
from entity.RequestType import RequestType


def startCrawlByLeaderboard(limit: int = 100):
    obj = CrawlByLeaderboard()
    datas = []
    for type in ParameterType:
        json_data = obj.doRequest(type, limit)
        datas.append(json_data)
    return datas


class CrawlByLeaderboard(MyCrawlerModel.Model):

    def __init__(self):
        MyCrawlerModel.Model.__init__(self)
        self.baseURL = "{0}/book/listRank?type={1}&limit={2}"
        self.type = RequestType.JSON
        self.base = baseURL

    def getURL(self, type: ParameterType, limit: int):
        return self.baseURL.format(self.base, type, limit)

    def doRequest(self, type: ParameterType, limit=100):
        if self.type == RequestType.JSON:
            json_data = self.requestJson(self.getURL(type.value, limit))
            return json_data
        else:
            raise ErrorRequestTypeException("错误的请求类型[JSON/PAGE].")


# if __name__ == '__main__':
#     print(CrawlByLeaderboard().doRequest(ParameterType.XINSHU))
# if __name__ == '__main__':
#     startCrawlByLeaderboard()
