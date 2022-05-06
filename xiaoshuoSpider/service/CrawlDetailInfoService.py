"""
    @Date: 2022/5/5
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  
"""
from entity.NovelItemBean import Item
from entity.ConstValue import baseURL
from service.CrawlNovelPageService import startCrawlPageDetail


def parseAndLoad(list_datas: list):
    ParseDatas(list_datas)


class ParseDatas(object):
    def __init__(self, list_datas: list):
        self.datas = list_datas
        self.__parseItem()

    def __parseItem(self):
        for response in self.datas:
            if response is not None:
                items = response['data']
                if items is not None and type(items) == list:
                    for item in items:
                        novelItem = Item(item)
                        url = self.getURL(novelItem.id)
                        startCrawlPageDetail(novelItem.id, url)
            else:
                print("response is None")

    def getURL(self, novelId: str):
        return "{0}/book/{1}.html".format(baseURL, novelId)