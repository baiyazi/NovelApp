"""
    @Date: 2022/5/5
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  
"""


class Item(object):
    def __init__(self, bean: dict):
        self.data = bean
        self.__analysisBean()

    def __analysisBean(self):
        self.id = self.data['id'].strip()
        self.catId = self.data['catId'].strip()
        self.catName = self.data['catName'].strip()
        self.picUrl = self.data['picUrl'].strip()
        self.bookName = self.data['bookName'].strip()
        self.authorName = self.data['authorName'].strip()
        self.bookDesc = self.data['bookDesc'].strip()
        self.score = "" if self.data['score'] is None else self.data['score'].strip()
        self.wordCount = self.data['wordCount'].strip()
        self.lastIndexUpdateTime = self.data['lastIndexUpdateTime'].strip()
        self.lastIndexId = self.data['lastIndexId'].strip()
        self.lastIndexName = self.data['lastIndexName'].strip()

    def __str__(self):
        return f"""
            id={self.id}, 
            catId={self.catId}, 
            catName={self.catName}, 
            picUrl = {self.picUrl}, 
            bookName = {self.bookName}, 
            authorName = {self.authorName}, 
            bookDesc = {self.bookDesc}, 
            score = {self.score}, 
            wordCount = {self.wordCount}, 
            lastIndexUpdateTime = {self.lastIndexUpdateTime}, 
            lastIndexId = {self.lastIndexId}, 
            lastIndexName = {self.lastIndexName}
        """
