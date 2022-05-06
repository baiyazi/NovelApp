"""
    @Date: 2022/5/5
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  
"""
from lxml.etree import tostring
from dao.DataBaseServiceDao import StorageNovelSectionDetail
from entity.RequestType import RequestType
from exceptions.MyException import ErrorRequestTypeException
from model import MyCrawlerModel
from entity.ConstValue import baseURL


def startCrawlPageDetail(novelId: str, url: str):
    url = CrawlByNovelPage(novelId, url).doRequest()
    content_link = CrawlAndGetContent(url).getContentLinks()
    section_links_list = CrawlAllSectionLink(content_link).getAllSectionLinks()
    snsd = StorageNovelSectionDetail()
    for _, link in enumerate(section_links_list):
        each_section_link = "{0}{1}".format(baseURL, link)
        contents = CrawlByCrawlByNovelPageDetail(each_section_link).doRequest()
        snsd.store(novelId, _+1, contents)


class CrawlByNovelPage(MyCrawlerModel.Model):

    def __init__(self, novelId: str, url: str):
        MyCrawlerModel.Model.__init__(self)
        self.baseURL = url
        self.type = RequestType.PAGE
        self.novelId = novelId

    def doRequest(self):
        if self.type == RequestType.PAGE:
            rootElement, strRootElement = self.requestPage(self.baseURL)
            pre = rootElement.xpath('//*[@id="preContentId"]/@value')[0]
            url = "{0}/book/{1}/{2}.html".format(baseURL, self.novelId, pre)
            return url
        else:
            raise ErrorRequestTypeException("错误的请求类型[JSON/PAGE].")


class CrawlByCrawlByNovelPageDetail(MyCrawlerModel.Model):

    def __init__(self, url: str):
        MyCrawlerModel.Model.__init__(self)
        self.baseURL = url
        self.type = RequestType.PAGE

    def doRequest(self):
        if self.type != RequestType.PAGE:
            raise ErrorRequestTypeException("错误的请求类型[JSON/PAGE].")
        else:
            rootElement, strRootElement = self.requestPage(self.baseURL)
            current_content = rootElement.xpath('//*[@id="showReading"]')[0]
            return (tostring(current_content, encoding="utf-8", pretty_print=True, method="html")).decode("utf-8")


class CrawlAndGetContent(MyCrawlerModel.Model):

    def __init__(self, url: str):
        MyCrawlerModel.Model.__init__(self)
        self.baseURL = url
        self.type = RequestType.PAGE

    def getContentLinks(self):
        if self.type != RequestType.PAGE:
            raise ErrorRequestTypeException("错误的请求类型[JSON/PAGE].")
        else:
            rootElement, strRootElement = self.requestPage(self.baseURL)
            link = rootElement.xpath("//a[@title='目录']/@href")[0]
            return "{0}/{1}".format(baseURL, link)


class CrawlAllSectionLink(MyCrawlerModel.Model):

    def __init__(self, url: str):
        MyCrawlerModel.Model.__init__(self)
        self.baseURL = url
        self.type = RequestType.PAGE

    def getAllSectionLinks(self):
        if self.type != RequestType.PAGE:
            raise ErrorRequestTypeException("错误的请求类型[JSON/PAGE].")
        else:
            rootElement, strRootElement = self.requestPage(self.baseURL)
            links = rootElement.xpath("//div[@class='dirList']//a/@href")
            return links