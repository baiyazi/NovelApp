"""
    @Date: 2022/5/4
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:
"""
import requests
from lxml.html import etree
from lxml import html


class Model(object):
    def __init__(self):
        self.header = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36",
            'Accept': "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            'Accept-Language': 'zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2',
        }
        self.cookie = {
            "_T_WM": "4c6dd2f044a60ebb3390f0b1db16917f",
            "SUB": "_2A25NcSDXDeRhGeNN41cZ8ibLzTuIHXVumkCfrDV6PUJbktAKLXHukW1NSZq7HVUw4YJu7-QZfc31o42PRopDtLbJ",
            "SUBP": "0033WrSXqPxfM725Ws9jqgMF55529P9D9W53lHwDl5MQNXGDi9G2KbvQ5NHD95Qfe0nf1hzRS0qNWs4Dqcj_i--4iK.Ei-2Ei--4iK.0iKnpi--Xi-i8i-27i--NiKLFiK.Ni--4iKnNiKyW;",
            "SSOLoginState": "1618301063"
        }

    def requestPage(self, url):
        response = requests.get(url, headers=self.header, cookies=self.cookie)
        response = response.content.decode()
        rootElement = etree.HTML(bytes(bytearray(response, encoding='utf-8'))) # lxml.etree._Element
        return rootElement, html.tostring(rootElement)

    def requestJson(self, url):
        print("请求的链接地址为：" + url)
        response = requests.get(url, headers=self.header, cookies=self.cookie)
        return response.json()