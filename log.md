# 3. 后记

## 1. 记录一下开发日程：
* `2022`年`5`月`4`日：决定要做这个东西，以及部分爬虫程序编码；
* `2022`年`5`月`5`日：完成爬虫程序编码【简略版】，但感觉数据基本够用了，所以决定就不再考虑模拟分页来获取小说数据了。另：小说封面图片没有下载，需要后续完善。完成部分`SpringBoot`+`Mybatis`的整合，以及`Mybatis generator`插件的配置工作。
* `2022`年`5`月`6`日：完成`SpringBoot`后台数据接口的查询功能，添加对应的图片下载到本地服务器的`Controller`，规则为根据数据库中的`picURL`来生成一个唯一的`md5`值，然后将对应的这个图片使用`HttpURLConnection`来进行下载到本地磁盘。同时，将本地磁盘的这个目录配置为`SpringBoot`的静态资源访问路径，故而可以直接访问。
* `2022`年`5`月`6`日：准备着手开始写基于`Jetpack`的`App`项目。
* `2022`年`5`月`7`日-`2022`年`5`月`8`日：复习`Kotlin`的常见语法，以及对之前学习的`Jetpack`部分知识点进行学习；
* `2022`年`5`月`9`日：开始编写基于`Jetpack`的`App`项目，完成了`Navigation`+`Viewpager`+`TableLayout`的主页导航，以及显示详情数据页面的部分逻辑。主要逻辑的承载于上拉加载更多的这个动作，使用的控件为`SmartRefreshLayout`，当然也只是简单使用，还没仔细看这个东西。
* `2022`年`5`月`10`日：基本完成了除加载后台数据的部分的页面逻辑的编写。数据使用本地模拟生成，还没有接入后台。因为还有一些细节需要调整。至于后台数据的接入就等过几天再弄。在这个过程中，发现自己对`Kotlin`、`Jetpack`还是不会的比较多，使用不熟练。对应的对于委托和`BindAdapter`这些东西还没有掌握；另外，对于在`Android`中使用`Dagger`也还没有了解。所以要学习的东西还很多，等这个项目做完后继续学习。

