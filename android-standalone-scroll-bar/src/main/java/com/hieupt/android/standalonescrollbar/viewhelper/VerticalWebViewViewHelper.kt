package com.hieupt.android.standalonescrollbar.viewhelper

import android.graphics.Canvas
import com.hieupt.android.standalonescrollbar.ScrollableView
import com.hieupt.android.standalonescrollbar.VerticalScrollableView
import com.hieupt.android.standalonescrollbar.view.OnDrawListener
import com.hieupt.android.standalonescrollbar.view.OnScrollChangedListener
import com.hieupt.android.standalonescrollbar.view.WebView2

/**
 * Created by HieuPT on 12/8/2020.
 */
internal class VerticalWebViewViewHelper(
    private val webView: WebView2
) : VerticalScrollableView {

    override val viewWidth: Int
        get() = webView.width

    override val viewHeight: Int
        get() = webView.height

    override val scrollRange: Int
        get() = webView.calculateVerticalScrollRange()

    override val scrollOffset: Int
        get() = webView.calculateVerticalScrollOffset()

    override fun addOnScrollChangedListener(onScrollChanged: (caller: ScrollableView) -> Unit) {
        webView.addOnScrollListener(object : OnScrollChangedListener {
            override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
                onScrollChanged(this@VerticalWebViewViewHelper)
            }
        })
    }

    override fun addOnDraw(onDraw: (caller: ScrollableView) -> Unit) {
        webView.addOnDrawListener(object : OnDrawListener {
            override fun onDraw(canvas: Canvas) {
                onDraw(this@VerticalWebViewViewHelper)
            }
        })
    }

    override fun scrollTo(offset: Int) {
        webView.scrollTo(webView.scrollX, offset)
    }
}