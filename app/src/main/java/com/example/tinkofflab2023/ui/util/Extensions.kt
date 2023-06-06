package com.example.tinkofflab2023.ui.util

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

val Number.toPx get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this.toFloat(),
    Resources.getSystem().displayMetrics)

fun Int.toDp(context: Context): Float {
    val scale = context.resources.displayMetrics.density
    return (this / scale)
}
