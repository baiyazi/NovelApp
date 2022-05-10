package com.mengfou.viewmodels

import androidx.lifecycle.*

/**
 * @author 梦否 on 2022/5/8
 * @blog https://mengfou.blog.csdn.net/
 */
class HomeFragmentViewModel:ViewModel(), LifecycleObserver{

    private val mTabLiveData:MutableLiveData<List<NovelType>> = MutableLiveData()

    val tabLiveData: LiveData<List<NovelType>>
        get() = mTabLiveData

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun active(){
        mTabLiveData.value = mutableListOf(
            NovelType.NOVEL_WUXIAXIANXIA,
            NovelType.NOVEL_LISHIJUNSHI,
            NovelType.NOVEL_KEHUANLINGYI,
            NovelType.NOVEL_WANGYOUJINGJI,
            NovelType.NOVEL_QIHUANXUANHUAN,
            NovelType.NOVEL_DUSHIYANQING,
        )
    }

    enum class NovelType(val type: Int){
        NOVEL_WUXIAXIANXIA(1),
        NOVEL_LISHIJUNSHI(2),
        NOVEL_KEHUANLINGYI(3),
        NOVEL_WANGYOUJINGJI(4),
        NOVEL_QIHUANXUANHUAN(5),
        NOVEL_DUSHIYANQING(6);
    }
}