package com.mengfou.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.mengfou.R
import com.mengfou.ui.home.HomeListFragment
import com.mengfou.viewmodels.HomeFragmentViewModel

/**
 * @author 梦否 on 2022/5/8
 * @blog https://mengfou.blog.csdn.net/
 */
class HomeFragmentPagerAdapter(private val resources: Resources, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    val datas = arrayListOf<HomeFragmentViewModel.NovelType>()

    override fun getCount() = datas.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when(datas[position]){
            HomeFragmentViewModel.NovelType.NOVEL_WUXIAXIANXIA -> {
                resources.getString(R.string.NOVEL_WUXIAXIANXIA)
            }
            HomeFragmentViewModel.NovelType.NOVEL_LISHIJUNSHI -> {
                resources.getString(R.string.NOVEL_LISHIJUNSHI)
            }
            HomeFragmentViewModel.NovelType.NOVEL_KEHUANLINGYI -> {
                resources.getString(R.string.NOVEL_KEHUANLINGYI)
            }
            HomeFragmentViewModel.NovelType.NOVEL_WANGYOUJINGJI -> {
                resources.getString(R.string.NOVEL_WANGYOUJINGJI)
            }
            HomeFragmentViewModel.NovelType.NOVEL_QIHUANXUANHUAN -> {
                resources.getString(R.string.NOVEL_QIHUANXUANHUAN)
            }
            HomeFragmentViewModel.NovelType.NOVEL_DUSHIYANQING -> {
                resources.getString(R.string.NOVEL_DUSHIYANQING)
            }
        }
    }

    override fun getItem(position: Int) = HomeListFragment.newInstance(datas[position])
}


