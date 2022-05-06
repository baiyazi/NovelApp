"""
    @Date: 2022/5/4
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  
"""
from dao import DataBaseServiceDao


def save_datas(list_datas: list):
    """
    存储数据到数据库中
    :param list_datas:
    :return:
    """
    DataBaseServiceDao.saveData(list_datas)
