package com.mengfou.netwrok

import androidx.lifecycle.LiveData
import com.mengfou.entity.NovelDetail
import com.mengfou.viewmodels.HomeFragmentViewModel

/**
 * @author 梦否 on 2022/5/9
 * @blog https://mengfou.blog.csdn.net/
 */
interface AppNetwrokAPI {
    fun doRequestNovelDetailFirstPage(novelType: HomeFragmentViewModel.NovelType): LiveData<List<NovelDetail>>?
    fun doRequestNovelDetailByPageNumber(novelType: HomeFragmentViewModel.NovelType, pageNumber: Int): LiveData<List<NovelDetail>>?
    fun doRequestNovelDetailById(id: String): NovelDetail
    fun doRequestNovelSectionPageByNovelIdAndSectionId(novelId: String?, sectionId: Int): String
}