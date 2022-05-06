"""
    @Date: 2022/5/4
    @Author: 梦否
    @Blog: https://mengfou.blog.csdn.net/
    @Info[功能说明]:  
"""


class ErrorRequestTypeException(Exception):
    def __init__(self, msg):
        self.msg = msg

    def __str__(self):
        return f"请求类型错误：{self.msg}"


class DataBaseConnectException(Exception):
    def __init__(self, msg):
        self.msg = msg

    def __str__(self):
        return f"数据库连接失败：{self.msg}"
