"""
    @Date: 2022/5/4
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  
"""
from enum import Enum


class ParameterType(Enum):
    DIANJI = 0  # 表示点击榜、
    XINSHU = 1  # 表示新书榜、
    GENGXIN = 2  # 表示更新榜、
    PINGLUN = 3  # 表示评论榜；


def getParameterTypeRealName(category: ParameterType):
    if category == ParameterType.DIANJI:
        return "点击榜"
    elif category == ParameterType.XINSHU:
        return "新书榜"
    elif category == ParameterType.GENGXIN:
        return "更新榜"
    else:
        return "评论榜"
