package com.rikkeisoft.mockrikkei.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.rikkeisoft.mockrikkei.R

fun ImageView.loadImageFromUrl(url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .error(R.drawable.ic_browse)
        .placeholder(R.drawable.item_new_demo)
        .into(this)
}

fun View.closeKeyBoard(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}