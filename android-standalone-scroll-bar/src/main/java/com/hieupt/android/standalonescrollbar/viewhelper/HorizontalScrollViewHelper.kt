package com.hieupt.android.standalonescrollbar.viewhelper

import android.annotation.SuppressLint
import android.graphics.Canvas
import com.hieupt.android.standalonescrollbar.HorizontalScrollableView
import com.hieupt.android.standalonescrollbar.ScrollableView
import com.hieupt.android.standalonescrollbar.view.HorizontalScrollView2
import com.hieupt.android.standalonescrollbar.view.OnDrawListener
import com.hieupt.android.standalonescrollbar.view.OnScrollChangedListener
import com.hieupt.android.standalonescrollbar.view.ScrollView2

/**
 * Created by HieuPT on 12/8/2020.
 */
internal class HorizontalScrollViewHelper(
    private val scrollView: HorizontalScrollView2
) : HorizontalScrollableView {

    override val viewWidth: Int
        get() = scrollView.width

    override val viewHeight: Int
        get() = scrollView.height

    override val scrollRange: Int
        get() = scrollView.calculateHorizontalScrollRange() + scrollView.paddingLeft + scrollView.paddingRight

    override val scrollOffset: Int
        get() = scrollView.calculateHorizontalScrollOffset()

    override fun addOnScrollChangedListener(onScrollChanged: (caller: ScrollableView) -> Unit) {
        scrollView.addOnScrollListener(object : OnScrollChangedListener {
            override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
                onScrollChanged(this@HorizontalScrollViewHelper)
            }
        })
    }

    override fun addOnDraw(onDraw: (caller: ScrollableView) -> Unit) {

        scrollView.addOnDrawListener(object : OnDrawListener {
            override fun onDraw(canvas: Canvas) {
                onDraw(this@HorizontalScrollViewHelper)
            }
        })
    }

    override fun scrollTo(offset: Int) {
        scrollView.scrollTo(offset, scrollView.scrollY)
    }
}