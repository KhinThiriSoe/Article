package com.khinthirisoe.cararticle.network

import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("dateTime") val dateTime: String,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("content") val content: List<Content_>,
    @SerializedName("ingress") val ingress: String,
    @SerializedName("image") val image: String,
    @SerializedName("created") val created: Int,
    @SerializedName("changed") val changed: Int
)