package com.mengfou.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.mengfou.entity.NovelDetail
import com.mengfou.repository.DetailRepository

/**
 * @author 梦否 on 2022/5/8
 * @blog https://mengfou.blog.csdn.net/
 */
class HomeListFragmentViewModel : ViewModel(), LifecycleObserver {

    var errorFlag = MutableLiveData<Boolean>()
    val novelType = MutableLiveData<HomeFragmentViewModel.NovelType>()
    var novelListDatas = MutableLiveData<List<NovelDetail>>()
    private var tempNovelListDatas: LiveData<List<NovelDetail>>? = null
    var current_page_number = FIRST_PAGE
    var isRefresh = false
    var isLoadMore = false

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        novelType.observeForever {
            loadFirstPageData()
        }
    }

    private val tempNovelListObserver = Observer<List<NovelDetail>> {
        if(it != null && it.isNotEmpty()) {
            novelListDatas.value = it
            errorFlag.value = false
        }
    }

    fun loadMoreData() {
        isLoadMore = true
        isRefresh = false
        tempNovelListDatas = novelType.value?.let {
            DetailRepository.loadMoreData(it, current_page_number++)
        }
        if (!(tempNovelListDatas != null || tempNovelListDatas?.value?.size ?: 0 > 0)) {
            errorFlag.value = true
        }
        tempNovelListDatas?.observeForever(tempNovelListObserver)
    }

    fun loadFirstPageData() {
        current_page_number = FIRST_PAGE
        isLoadMore = false
        isRefresh = true
        tempNovelListDatas = novelType.value?.let {
            DetailRepository.loadFirstPage(it)
        }
        if (!(tempNovelListDatas != null || tempNovelListDatas?.value?.size ?: 0 > 0)) {
            errorFlag.value = true
        }
        tempNovelListDatas?.apply{
            observeForever(tempNovelListObserver)
            current_page_number++
        }
    }

    companion object {
        var FIRST_PAGE = 1
    }
}
