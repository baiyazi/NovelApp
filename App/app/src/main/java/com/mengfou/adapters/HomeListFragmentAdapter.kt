package com.mengfou.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mengfou.R
import com.mengfou.databinding.ItemHomeChildBinding
import com.mengfou.entity.NovelDetail
import com.mengfou.ui.home.HomeListFragment
import com.mengfou.utils.ActivityJumpUtil
import com.mengfou.viewmodels.HomeFragmentViewModel
import com.mengfou.viewmodels.ItemChildViewModel

/**
 * @author 梦否 on 2022/5/8
 * @blog https://mengfou.blog.csdn.net/
 */
class HomeListFragmentAdapter(val fragment: Fragment) : RecyclerView.Adapter<HomeListFragmentAdapter.ItemHolder>() {

    private var datas = mutableListOf<NovelDetail>()
    private lateinit var binding: ItemHomeChildBinding
    private var novelType: HomeFragmentViewModel.NovelType? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        binding = DataBindingUtil.inflate<ItemHomeChildBinding>(
            LayoutInflater.from(fragment.context),
            R.layout.item_home_child,
            parent,
            false
        )
        val itemViewHolder = ItemHolder(binding.root).apply {
            _binding = binding
        }
        return itemViewHolder
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder._binding?.viewModel = ItemChildViewModel(datas[position]).apply {
            clickObserver.observe(fragment, object : Observer<NovelDetail> {
                // todo 跳转到详情页面  holder.getAdapterPosition()
                override fun onChanged(novelDetail: NovelDetail?) {
                    ActivityJumpUtil.jumpToDetailFragment(fragment, novelType!!, datas[holder.layoutPosition])
                }
            })
        }
    }


    override fun getItemCount() = datas.size

    fun updateList(list: List<NovelDetail>?, isRefreshFlag: Boolean) {
        list?.run {
            if (isRefreshFlag) {  // 必须先清除以前的数据，再装入
                val size = datas.size
                datas.clear()
                notifyItemRangeRemoved(0, size) // 注意：clear之后需要通知
            }
            datas.addAll(list)
            notifyItemChanged(datas.size - list.size, datas.size)
        }
    }

    fun setNovelType(value: HomeFragmentViewModel.NovelType?) {
        novelType = value
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _binding: ItemHomeChildBinding? = null
    }
}