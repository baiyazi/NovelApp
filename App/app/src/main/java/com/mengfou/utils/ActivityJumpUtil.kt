package com.mengfou.utils

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mengfou.R
import com.mengfou.entity.NovelDetail
import com.mengfou.ui.activity.DetailActivity
import com.mengfou.viewmodels.HomeFragmentViewModel

/**
 * @author 梦否 on 2022/5/9
 * @blog https://mengfou.blog.csdn.net/
 */
class ActivityJumpUtil {
    companion object {
        const val NOVEL_BOOK_TYPE = "NOVEL_BOOK_TYPE"
        const val NOVEL_BOOK_DETAIL = "NOVEL_BOOK_DETAIL"

        fun jumpToDetailActivity(
            sourceFragment: Fragment,
            novelType: HomeFragmentViewModel.NovelType,
            novelDetail: NovelDetail
        ) {
            val sourceActivity = sourceFragment.requireActivity()
            val intent = Intent().apply {
                setClass(sourceActivity, DetailActivity::class.java)
                putExtra(NOVEL_BOOK_TYPE, novelType)
                putExtra(NOVEL_BOOK_DETAIL, novelDetail)
            }
            sourceActivity.startActivity(intent)
        }

        fun jumpToDetailFragment(sourceFragment: Fragment, novelType: HomeFragmentViewModel.NovelType, novelDetail: NovelDetail) {
            val navController = sourceFragment.findNavController()
            navController.navigate(R.id.action_homeFragment_to_detailFragment, Bundle().apply {
                putParcelable(NOVEL_BOOK_DETAIL, novelDetail)
                putSerializable(NOVEL_BOOK_TYPE, novelType)
            })
        }

        fun jumpToContentActivity(
            sourceFragment: Fragment,
            novelDetail: NovelDetail
        ) {
            val sourceActivity = sourceFragment.requireActivity()
            val intent = Intent().apply {
                setClass(sourceActivity, DetailActivity::class.java)
                putExtra(NOVEL_BOOK_DETAIL, novelDetail)
            }
            sourceActivity.startActivity(intent)
        }
    }


}