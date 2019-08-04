package com.khinthirisoe.cararticle.network

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("status") val status: String,
    @SerializedName("content") val content: List<Content>,
    @SerializedName("serverTime") val serverTime: Int
)