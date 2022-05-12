package com.mengfou.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * @author 梦否 on 2022/5/12
 * @blog https://mengfou.blog.csdn.net/
 */
abstract class BaseHorizontalPopupLayout: FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    abstract fun closeView()
    abstract fun openView()

    companion object {
        val OPEN_ANIMATION_TIME = 200L
        val CLOSE_ANIMATION_TIME = 600L
    }
}