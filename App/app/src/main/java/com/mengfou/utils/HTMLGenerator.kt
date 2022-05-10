package com.mengfou.utils

import java.lang.StringBuilder

/**
 * @author 梦否 on 2022/5/10
 * @blog https://mengfou.blog.csdn.net/
 */
class HTMLGenerator {

    companion object {
        fun loadSectionPage(section: String): String {
            val html: StringBuilder = StringBuilder()
            html.append("<html><head><meta http-equiv='content-type' content='text/html; charset=utf-8'>")
            html.append("<meta charset='utf-8'  content='1'></head><body style='color: black'>")
            html.append(section)
            html.append("</body><style>.readBox{ background: #f4f1ea;}</style></html>")
            return html.toString()
        }

        fun loadDefaultHTMLInfoPage(): String {
            val section = "<h3>章节数据加载失败！</h3>"
            return loadSectionPage(section)
        }
    }
}