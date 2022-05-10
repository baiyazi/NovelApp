package com.mengfou.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mengfou.R
import com.mengfou.adapters.HomeListFragmentAdapter
import com.mengfou.databinding.FragmentHomeListBinding
import com.mengfou.entity.NovelDetail
import com.mengfou.utils.autoCleared
import com.mengfou.viewmodels.HomeFragmentViewModel
import com.mengfou.viewmodels.HomeListFragmentViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout

/**
 * @author 梦否 on 2022/5/8
 * @blog https://mengfou.blog.csdn.net/
 */
class HomeListFragment() : Fragment() {

    private var binding by autoCleared<FragmentHomeListBinding>()
    private lateinit var viewModel: HomeListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_list, container, false)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(HomeListFragmentViewModel::class.java)
        lifecycle.addObserver(viewModel)
        binding.viewModel = viewModel
        return binding.root
    }

    private lateinit var homeListFragmentAdapter: HomeListFragmentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val novelType = arguments?.getSerializable(NOVEL_TYPE)
        viewModel.novelType.value = novelType as HomeFragmentViewModel.NovelType
        viewModel.novelListDatas.observe(viewLifecycleOwner, listDataObserver)

        binding.smartRefreshLayout.apply(::addSmartRefreshLayoutListener)
        homeListFragmentAdapter = HomeListFragmentAdapter(this)
        binding.recyclerView.adapter = homeListFragmentAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

    }

    private var listDataObserver = Observer<List<NovelDetail>> {
        homeListFragmentAdapter.updateList(it, viewModel.isRefresh)
        homeListFragmentAdapter.setNovelType(viewModel.novelType.value)
    }

    private fun addSmartRefreshLayoutListener(smartRefreshLayout: SmartRefreshLayout) {
        smartRefreshLayout.apply {
            setOnRefreshListener {  // 下拉刷新
                viewModel.loadFirstPageData()
                binding.smartRefreshLayout.finishRefresh(200)
            }
            setOnLoadMoreListener {  // 上拉加载更多
                viewModel.loadMoreData()
                binding.smartRefreshLayout.finishLoadMore(200)
            }
        }
    }

    companion object {
        private const val NOVEL_TYPE = "NOVEL_TYPE"
        fun newInstance(type: HomeFragmentViewModel.NovelType): HomeListFragment {
            val args = Bundle()
            args.putSerializable(NOVEL_TYPE, type)
            val fragment = HomeListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
