package com.khinthirisoe.cararticle.network

import com.google.gson.annotations.SerializedName

data class Content_(
    @SerializedName("type") val type: String,
    @SerializedName("subject") val subject: String,
    @SerializedName("description") val description: String
)