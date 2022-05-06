"""
    @Date: 2022/5/4
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  
"""

from enum import Enum


class Category(Enum):
    XUANHUAN = 1  # 玄幻奇幻
    WUXIAO = 2  # 武侠仙侠
    DUSHI = 3  # 都市言情
    LISHI = 4  # 历史军事
    KEHUAN = 5  # 科幻灵异
    WANGYOU = 6  # 网游竞技


def getCategoryRealName(category: Category):
    if category == Category.XUANHUAN:
        return "玄幻奇幻"
    elif category == Category.WUXIAO:
        return "武侠仙侠"
    elif category == Category.DUSHI:
        return "都市言情"
    elif category == Category.LISHI:
        return "历史军事"
    elif category == Category.KEHUAN:
        return "科幻灵异"
    else:
        return "网游竞技"
