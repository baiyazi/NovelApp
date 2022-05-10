package com.mengfou.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.mengfou.R


object ImageLoader{
    fun loadImage(view: ImageView, imageUrl: String){
        val url = convertURL(imageUrl)
        Glide.with(view)
            .load(url)
            .placeholder(R.drawable.default_cover)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }

    // todo 项目中 数据库中的图片地址需要转换一下到后台静态资源文件
    private fun convertURL(imageUrl: String): String {
        return ""
    }
}



@BindingAdapter("imageFromUrl")
fun imageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        ImageLoader.loadImage(view, imageUrl)
    }
}