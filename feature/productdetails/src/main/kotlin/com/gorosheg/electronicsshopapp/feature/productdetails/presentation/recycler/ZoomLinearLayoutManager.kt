package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.math.min

class ZoomLinearLayoutManager(
    context: Context,
    private val shrinkDistance: Float = 0.9f,
    private val shrinkAmount: Float = 0.15f,
) : LinearLayoutManager(context, HORIZONTAL, false) {

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
        scaleChildren()
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        return if (orientation == HORIZONTAL) {
            super.scrollHorizontallyBy(dx, recycler, state).also { scaleChildren() }
        } else {
            0
        }
    }

    private fun scaleChildren() {
        val midpoint = width / 2f
        val distance = shrinkDistance * midpoint

        for (i in 0 until childCount) {
            val child = getChildAt(i) as View
            val mathMagic = min(distance, abs(midpoint - (getDecoratedRight(child) + getDecoratedLeft(child)) / 2f))
            val scale = 1f - shrinkAmount * mathMagic / distance

            child.scaleX = scale
            child.scaleY = scale
        }
    }
}