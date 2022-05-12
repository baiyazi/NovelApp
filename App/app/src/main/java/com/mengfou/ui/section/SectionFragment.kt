package com.mengfou.ui.section

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mengfou.R
import com.mengfou.databinding.FragmentSectionBinding
import com.mengfou.entity.NovelDetail
import com.mengfou.repository.DetailRepository
import com.mengfou.ui.detail.DetailFragment
import com.mengfou.utils.HTMLGenerator
import com.mengfou.viewmodels.HomeFragmentViewModel
import com.mengfou.views.HorizontalPopupLayout
import com.mengfou.views.IHorizontalPopupLayoutItemClickListener
import com.scwang.smartrefresh.layout.SmartRefreshLayout


class SectionFragment : Fragment() {

    private var binding: FragmentSectionBinding? = null
    private var novelType: HomeFragmentViewModel.NovelType? = null
    private var novelDetail: NovelDetail? = null
    private var currentSectionId: Int = 1  // 小说章节编号从1开始
    private lateinit var horizontalPopupLayout: HorizontalPopupLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if(binding == null) {
            binding = DataBindingUtil.inflate<FragmentSectionBinding>(
                inflater,
                R.layout.fragment_section,
                container,
                false
            )
            novelType = arguments?.getSerializable(DetailFragment.NOVEL_BOOK_TYPE) as HomeFragmentViewModel.NovelType
            novelDetail = arguments?.getParcelable<NovelDetail>(DetailFragment.NOVEL_BOOK_DETAIL)
        }
        return binding!!.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = novelDetail?.bookName
        val html = loadPageHTMLString(novelDetail)
        binding!!.apply {
            smartRefreshLayout.apply(::addSmartRefreshLayoutListener)
            webView.apply {
                setPadding(0, 0, 0, 0)
                settings.javaScriptEnabled = true
                settings.defaultTextEncodingName = "utf-8"
                webViewClient = WebViewClient()
                loadDataWithBaseURL(null, html, "text/html", "utf-8", null)
            }
            fab.setOnClickListener(fabOnClickListener)
            this@SectionFragment.horizontalPopupLayout = this.horizontalPopupLayout
        }
    }

    val fabOnClickListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            // todo 这里应该是startActivityForResult
            // ActivityJumpUtil.jumpToContentActivity(this@SectionFragment, novelDetail!!)
            horizontalPopupLayout.openView()
            horizontalPopupLayout.setOnItemClickListener(object :
                IHorizontalPopupLayoutItemClickListener {
                override fun onItemClick(itemId: Int) {
                    Log.e("TAG", "SectionFragment => onItemClick: ${itemId}" )
                }
            })
        }
    }

    private fun addSmartRefreshLayoutListener(smartRefreshLayout: SmartRefreshLayout) {
        smartRefreshLayout.apply {
            setOnRefreshListener {  // 下拉刷新
                Log.e("TAG", "SectionFragment => addSmartRefreshLayoutListener: 下拉刷新" )
                this.finishRefresh(200)
            }
            setOnLoadMoreListener {
                Log.e("TAG", "SectionFragment => addSmartRefreshLayoutListener: 上拉加载" )
                this.finishLoadMore(200)
            }
        }
    }

    private fun loadPageHTMLString(novelDetail: NovelDetail?): String {
        var content: String? = null
        novelDetail?.let{
            content = DetailRepository.loadNovelSectionByIdAndSectionId(novelDetail.id, currentSectionId)
        }
        if(content.isNullOrEmpty()) {
            content = HTMLGenerator.loadDefaultHTMLInfoPage()
        }
        return HTMLGenerator.loadSectionPage(content!!)
    }
}