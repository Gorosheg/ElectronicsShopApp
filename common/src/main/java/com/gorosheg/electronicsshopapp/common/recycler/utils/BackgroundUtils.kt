package com.gorosheg.electronicsshopapp.common.recycler.utils

import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun View.setCompatBackground(@DrawableRes drawableResId: Int) {
    background = ContextCompat.getDrawable(context, drawableResId)
}