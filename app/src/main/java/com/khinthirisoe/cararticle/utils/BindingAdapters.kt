package com.khinthirisoe.cararticle.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
}

@BindingAdapter("dateTime")
fun setDateTime(textView: TextView, datetime: String) {
   textView.text = checkDate(datetime)
}
