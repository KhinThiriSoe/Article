package com.khinthirisoe.cararticle.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.khinthirisoe.cararticle.domain.ArticleContent

@Entity
data class DatabaseArticle constructor(
    @PrimaryKey
    val image: String,
    val title: String,
    val datetime: String,
    val ingress: String)

fun List<DatabaseArticle>.asDomainModel(): List<ArticleContent> {
    return map {
        ArticleContent(
            image = it.image,
            title = it.title,
            datetime = it.datetime,
            ingress = it.ingress
        )
    }
}