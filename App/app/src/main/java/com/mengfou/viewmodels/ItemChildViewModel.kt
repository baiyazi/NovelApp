package com.mengfou.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mengfou.entity.NovelDetail

/**
 * @author 梦否 on 2022/5/9
 * @blog https://mengfou.blog.csdn.net/
 */
class ItemChildViewModel(val novelDetail: NovelDetail) {

    val clickObserver: MutableLiveData<NovelDetail> = MutableLiveData()

    fun onClick(){
        clickObserver.value = novelDetail
    }
}