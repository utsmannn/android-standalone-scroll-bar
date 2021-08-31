package com.hieupt.android.standalonescrollbar.viewhelper

import android.graphics.Canvas
import com.hieupt.android.standalonescrollbar.ScrollableView
import com.hieupt.android.standalonescrollbar.VerticalScrollableView
import com.hieupt.android.standalonescrollbar.view.OnDrawListener
import com.hieupt.android.standalonescrollbar.view.OnScrollChangedListener
import com.hieupt.android.standalonescrollbar.view.ScrollView2

/**
 * Created by HieuPT on 12/8/2020.
 */
internal class VerticalScrollViewHelper(
    private val scrollView: ScrollView2
) : VerticalScrollableView {

    override val viewWidth: Int
        get() = scrollView.width

    override val viewHeight: Int
        get() = scrollView.height

    override val scrollRange: Int
        get() = scrollView.calculateVerticalScrollRange() + scrollView.paddingTop + scrollView.paddingBottom

    override val scrollOffset: Int
        get() = scrollView.calculateVerticalScrollOffset()

    override fun addOnScrollChangedListener(onScrollChanged: (caller: ScrollableView) -> Unit) {
        scrollView.addOnScrollListener(object : OnScrollChangedListener {
            override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
                onScrollChanged(this@VerticalScrollViewHelper)
            }
        })
    }

    override fun addOnDraw(onDraw: (caller: ScrollableView) -> Unit) {
        scrollView.addOnDrawListener(object : OnDrawListener {
            override fun onDraw(canvas: Canvas) {
                onDraw(this@VerticalScrollViewHelper)
            }
        })
    }

    override fun scrollTo(offset: Int) {
        scrollView.scrollTo(scrollView.scrollX, offset)
    }
}