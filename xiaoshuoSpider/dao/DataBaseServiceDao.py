"""
    @Date: 2022/5/5
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  
"""
from dao.BaseDataBaseManager import Model
from entity.NovelItemBean import Item


def saveData(json_data: list):
    CreateTableModel().createTables()
    StorageNovelItemBean().storageBeans(json_data)


class CreateTableModel(Model):
    def __init__(self):
        super().__init__()

    def __createLeaderboardTable(self):
        cursor = self.db.cursor()
        sql = """
                create table IF NOT EXISTS `LEADERBOARD`(
                  `id` varchar(30) PRIMARY KEY NOT NULL,
                  `catId` int DEFAULT '0',
                  `catName` varchar(20) DEFAULT NULL,
                  `picUrl` varchar(200) DEFAULT NULL,
                  `bookName` varchar(100) DEFAULT NULL,
                  `authorName` varchar(50) DEFAULT NULL,
                  `bookDesc` varchar(2000) DEFAULT NULL,
                  `score` varchar(20) DEFAULT NULL,
                  `wordCount` varchar(10) DEFAULT NULL,
                  `lastIndexUpdateTime` varchar(50) DEFAULT NULL,
                  `lastIndexId` varchar(30) DEFAULT NULL,
                  `lastIndexName` varchar(100) DEFAULT NULL
                ) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
        """
        cursor.execute(sql)
        self.db.commit()


    def __createNovelSectionDetail(self):
        cursor = self.db.cursor()
        sql = """
                create table IF NOT EXISTS `LBNOVELSECTIONDETAIL`(
                  `id` varchar(30) DEFAULT NULL COMMENT '小说',
                  `sectionId` int DEFAULT '0' COMMENT '章节的标识',
                  `sectionDetail` longtext,
                  `identityId` int NOT NULL AUTO_INCREMENT,
                  PRIMARY KEY (`identityId`)
                ) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
        """
        cursor.execute(sql)
        self.db.commit()

    def createTables(self):
        self.__createNovelSectionDetail()
        self.__createLeaderboardTable()


class StorageNovelSectionDetail(Model):
    def __init__(self):
        super().__init__()

    def store(self, novelId: str, section: int, contents: str):
        if not self.hasExist(novelId, section):
            cursor = self.db.cursor()
            sql = """
                insert into LBNOVELSECTIONDETAIL(
                    id,
                    sectionId,
                    sectionDetail
                ) values(%s, %s, %s)
            """
            cursor.execute(sql, [novelId, section, contents])
            self.db.commit()

    def hasExist(self, id, sectionId):
        cursor = self.db.cursor()
        sql = "select * from LBNOVELSECTIONDETAIL where id={0} and sectionId={1}".format(id, sectionId)
        result = None
        try:
            result = cursor.execute(sql)
        except Exception as e:
            print(f"数据库LBNOVELSECTIONDETAIL可能不存在！{e}")
        return result is not None and result != 0


class StorageNovelItemBean(Model):
    def __init__(self):
        super().__init__()

    def storageBeans(self, json_data: list):
        for response in json_data:
            if response is not None:
                datas = response['data']
                for data in datas:
                    if data is not None and type(data) == dict:
                        self.storageBean(Item(data))

    def storageBean(self, item: Item):
        cursor = self.db.cursor()
        if not self.hasExist(item):
            sql = """
                insert into LEADERBOARD(
                    id,
                    catId,
                    catName,
                    picUrl,
                    bookName,
                    authorName,
                    bookDesc,
                    score,
                    wordCount,
                    lastIndexUpdateTime,
                    lastIndexId,
                    lastIndexName
                ) values(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
            """
            cursor.execute(sql, [item.id, item.catId, item.catName, item.picUrl, item.bookName, item.authorName
                , item.bookDesc, item.score, item.wordCount, item.lastIndexUpdateTime, item.lastIndexId,
                                 item.lastIndexName])
            self.db.commit()

    def hasExist(self, item):
        cursor = self.db.cursor()
        sql = "select * from LEADERBOARD where id={0}".format(item.id)
        result = None
        try:
            result = cursor.execute(sql)
        except Exception as e:
            print(f"数据库LBNOVELSECTIONDETAIL可能不存在！{e}")
        return result is not None and result != 0
