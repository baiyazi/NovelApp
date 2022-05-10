package com.mengfou.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.mengfou.entity.NovelDetail
import com.mengfou.netwrok.NetwrokRequestClient
import com.mengfou.viewmodels.HomeFragmentViewModel

/**
 * @author 梦否 on 2022/5/8
 * @blog https://mengfou.blog.csdn.net/
 */
class DetailRepository {

    companion object {
        private var netwrokRequestClient: NetwrokRequestClient = NetwrokRequestClient()

        fun loadFirstPage(novelType: HomeFragmentViewModel.NovelType): LiveData<List<NovelDetail>>? {
            return netwrokRequestClient.doRequestNovelDetailFirstPage(novelType)
        }

        fun loadMoreData(
            novelType: HomeFragmentViewModel.NovelType,
            pageNumber: Int
        ): LiveData<List<NovelDetail>>? {
            return netwrokRequestClient.doRequestNovelDetailByPageNumber(novelType, pageNumber)
        }

        fun loadNovelDetailById(id: String?): NovelDetail? {
            if (!id.isNullOrEmpty()) {
                return netwrokRequestClient.doRequestNovelDetailById(id)
            }
            return null
        }

        fun loadNovelSectionByIdAndSectionId(novelId: String?, sectionId: Int): String? {
            if (!novelId.isNullOrEmpty()) {
                return netwrokRequestClient.doRequestNovelSectionPageByNovelIdAndSectionId(novelId, sectionId)
            }
            return null
        }
    }
}