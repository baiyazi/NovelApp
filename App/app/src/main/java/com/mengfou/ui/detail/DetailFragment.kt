package com.mengfou.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.mengfou.R
import com.mengfou.adapters.DetailFragmentListViewAdapter
import com.mengfou.databinding.FragmentDetailBinding
import com.mengfou.entity.NovelDetail
import com.mengfou.repository.DetailRepository
import com.mengfou.ui.home.HomeListFragment
import com.mengfou.utils.ActivityJumpUtil
import com.mengfou.utils.ImageLoader
import com.mengfou.utils.autoCleared
import com.mengfou.viewmodels.DetailFragmentViewModel
import com.mengfou.viewmodels.HomeFragmentViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlin.math.abs

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    private var novelType: HomeFragmentViewModel.NovelType? = null
    private var novelDetail: MutableLiveData<NovelDetail> = MutableLiveData()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
            novelType =
                arguments?.getSerializable(ActivityJumpUtil.NOVEL_BOOK_TYPE) as HomeFragmentViewModel.NovelType
            novelDetail.value = arguments?.getParcelable<NovelDetail>(ActivityJumpUtil.NOVEL_BOOK_DETAIL)
            binding?.detailBookName?.text = novelDetail.value?.bookName
        }
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            detailSmartRefreshLayout.apply(::addSmartRefreshLayoutListener)
            val detailFragmentListViewAdapter = DetailFragmentListViewAdapter(this@DetailFragment)
            detailRecyclerView.adapter = detailFragmentListViewAdapter
            novelDetail.observeForever {
                (detailRecyclerView.adapter as DetailFragmentListViewAdapter).updateList(it, true)
            }
            novelDetail.value?.picUrl?.let {
                ImageLoader.loadImage(detailBookPic, it)
            }
        }
    }

    private fun addSmartRefreshLayoutListener(smartRefreshLayout: SmartRefreshLayout) {
        smartRefreshLayout.apply {
            setOnRefreshListener {  // 下拉刷新
                novelDetail.value = DetailRepository.loadNovelDetailById(novelDetail.value?.id)
                this.finishRefresh(200)
            }
            setOnLoadMoreListener {
                val navController = Navigation.findNavController(smartRefreshLayout)
                this.finishLoadMore(200)
                navController.navigate(R.id.action_detailFragment_to_sectionFragment, Bundle().apply {
                    putParcelable(NOVEL_BOOK_DETAIL, novelDetail.value)
                    putSerializable(NOVEL_BOOK_TYPE, novelType)
                })
            }
        }
    }

    companion object{
        const val NOVEL_BOOK_TYPE = "NOVEL_BOOK_TYPE"
        const val NOVEL_BOOK_DETAIL = "NOVEL_BOOK_DETAIL"
    }
}