package com.mengfou.views

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.MenuItem
import android.view.MotionEvent
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import com.google.android.material.navigation.NavigationView


/**
 * @author 梦否 on 2022/5/11
 * @blog https://mengfou.blog.csdn.net/
 */
class HorizontalPopupLayout : BaseHorizontalPopupLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var mPopupViewWidth: Int = 0
    private var mNavigationView: NavigationView? = null
    private var mIsOpenViewFlag: Boolean = false
    private var mContentInLeft = false
    private var onClickListener: IHorizontalPopupLayoutItemClickListener? = null

    /**
     * 设置menuItem点击的监听接口
     */
    fun setOnItemClickListener(l: IHorizontalPopupLayoutItemClickListener) {
        this.onClickListener = l
    }

    @SuppressLint("RtlHardcoded", "UseCompatLoadingForColorStateLists")
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (childCount != 2) {
            throw Exception("在{$TAG}布局文件中，中必须有两个直接子元素！")
        }
        for (index in 0..childCount) {
            val child = getChildAt(index)
            if (child != null) {
                if (child is NavigationView) {
                    mPopupViewWidth = child.measuredWidth
                    try {
                        mNavigationView = getChildAt(index) as NavigationView
                    } catch (e: java.lang.Exception) {
                        throw Exception("在{$TAG}布局文件中，中第二个直接子元素必须为：NavigationView！")
                    }
                    when ((mNavigationView!!.layoutParams as FrameLayout.LayoutParams).gravity) {
                        Gravity.START, Gravity.LEFT -> {
                            child.layout(-mPopupViewWidth, 0, 0, measuredHeight)
                            mContentInLeft = true
                        }
                        Gravity.END, Gravity.RIGHT -> {
                            child.layout(
                                measuredWidth,
                                0,
                                measuredWidth + mPopupViewWidth,
                                measuredHeight
                            )
                            mContentInLeft = false
                        }
                        else -> {
                            child.layout(-mPopupViewWidth, 0, 0, measuredHeight)
                            mContentInLeft = true
                        }
                    }
                    mNavigationView!!.setNavigationItemSelectedListener(listener)
                } else {
                    child.layout(0, 0, measuredWidth, measuredHeight)
                }
            }
        }
        if (mNavigationView == null || !(mNavigationView is NavigationView)) {
            throw Exception("在{$TAG}布局文件中，第二个直接子元素必须是NavigationView！")
        }
    }


    private val listener = object : NavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
            onClickListener?.onItemClick(menuItem.itemId)
            closeView()
            return true
        }
    }

    override fun onInterceptTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                return isCloseNavigationView(event.x)
            }
        }
        return super.onInterceptTouchEvent(event)
    }

    private fun isCloseNavigationView(x: Float): Boolean {
        mNavigationView?.let {
            if ((x < (measuredWidth - it.measuredWidth) && mIsOpenViewFlag && !mContentInLeft)
                || ((x > it.measuredWidth && mIsOpenViewFlag && mContentInLeft))
            ) {
                closeView()
                return true
            }
        }
        return false
    }

    override fun closeView() {
        if (!mIsOpenViewFlag) return
        mIsOpenViewFlag = false
        if (mContentInLeft) {
            animation(-mPopupViewWidth, CLOSE_ANIMATION_TIME, AccelerateDecelerateInterpolator())
        } else {
            animation(mPopupViewWidth, CLOSE_ANIMATION_TIME, AccelerateDecelerateInterpolator())
        }
    }

    override fun openView() {
        if (mIsOpenViewFlag) return
        mIsOpenViewFlag = true
        if (mContentInLeft) {
            animation(mPopupViewWidth, OPEN_ANIMATION_TIME, LinearInterpolator())
        } else {
            animation(-mPopupViewWidth, OPEN_ANIMATION_TIME, LinearInterpolator())
        }
    }

    @SuppressLint("ObjectAnimatorBinding", "Recycle")
    private fun animation(distance: Int, time: Long, interpolator: Interpolator) {
        mNavigationView?.apply {
            val animator = ObjectAnimator.ofFloat(
                mNavigationView,
                "translationX",
                1f * distance
            )
            animator.duration = time
            animator.interpolator = interpolator
            animator.start()
        }
    }

    companion object {
        private val TAG = HorizontalPopupLayout.javaClass.name
    }
}