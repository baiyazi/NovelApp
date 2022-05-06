"""
    @Date: 2022/5/5
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  
"""
import pymysql

from exceptions.MyException import DataBaseConnectException


class Model(object):
    def __init__(self):
        self.__connect()
        self.databaseName = "novel"

    def __connect(self):
        try:
            self.db = pymysql.connect(host="localhost", user="root", passwd="123456", port=3306, db="novel")
        except Exception as e:
            raise DataBaseConnectException(e)

    def deleteDataBase(self):
        """
        用于删除MySql数据库中novel数据库所有信息，谨慎使用！！！
        :return:
        """
        cursor = self.db.cursor()
        sql = "drop database if exists {0}".format(self.databaseName)
        cursor.execute(sql)
        sql = "create database {0}".format(self.databaseName)
        cursor.execute(sql)
        self.__connect()