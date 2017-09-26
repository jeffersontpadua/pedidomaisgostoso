package com.medium.jeffersontpadua.pedidomaisgostoso.dashboard

import android.content.Context
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewManager
import org.jetbrains.anko.custom.ankoView

/**
 * Created by jeffe on 21/09/2017.
 */
fun ViewManager.supportToolbar(init: Toolbar.() -> Unit): Toolbar = ankoView({Toolbar(it)}, 0) {
    init()
}

fun Context.color(@ColorRes color: Int) = ContextCompat.getColor(this, color)

fun View.color(@ColorRes color: Int) = this.context.color(color)