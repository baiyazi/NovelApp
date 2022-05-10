package com.mengfou.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mengfou.R
import com.mengfou.databinding.ItemDetailBinding
import com.mengfou.databinding.ItemHomeChildBinding
import com.mengfou.entity.NovelDetail
import com.mengfou.utils.ActivityJumpUtil
import com.mengfou.viewmodels.HomeFragmentViewModel
import com.mengfou.viewmodels.ItemChildViewModel

/**
 * @author 梦否 on 2022/5/10
 * @blog https://mengfou.blog.csdn.net/
 */
class DetailFragmentListViewAdapter(val fragment: Fragment) :
    RecyclerView.Adapter<DetailFragmentListViewAdapter.ItemHolder>() {

    private var datas = mutableListOf<Pair<Int, String>>()
    private lateinit var binding: ItemDetailBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        binding = DataBindingUtil.inflate<ItemDetailBinding>(
            LayoutInflater.from(fragment.context),
            R.layout.item_detail,
            parent,
            false
        )
        val itemViewHolder = ItemHolder(binding.root).apply {
            _binding = binding
        }
        return itemViewHolder
    }

    fun updateList(novelDetail: NovelDetail?, isRefresh: Boolean) {
        novelDetail?.run {
            if (isRefresh) {
                val size = datas.size
                datas.clear()
                notifyItemRangeRemoved(0, size) // 注意：clear之后需要通知
            }
            datas = novelDetail.getNovelDetailItems()
        }
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        datas.get(position).let {
            holder._binding?.detailItemTitle?.text = fragment.resources.getString(it.first)
            holder._binding?.detailItemContent?.text = it.second
        }
    }

    override fun getItemCount() = datas.size

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _binding: ItemDetailBinding? = null
    }
}