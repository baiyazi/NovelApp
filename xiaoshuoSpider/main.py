"""
    @Date: 2022/5/4
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  入口
"""
from controller import MyNovelController as crawler

if __name__ == '__main__':
    # 需要首先确保数据库中有novel这个数据库存在
    crawler.beginCrawler()
