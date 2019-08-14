package com.khinthirisoe.cararticle.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleContent(
    val title: String,
    val datetime: String,
    val ingress: String,
    val image: String
): Parcelable