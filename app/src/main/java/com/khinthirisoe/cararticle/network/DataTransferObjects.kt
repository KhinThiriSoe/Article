package com.khinthirisoe.cararticle.network

import com.khinthirisoe.cararticle.database.DatabaseArticle
import com.khinthirisoe.cararticle.domain.ArticleContent

fun Article.asDomainModel(): List<ArticleContent> {
    return content.map {
        ArticleContent(
            title = it.title,
            datetime = it.dateTime,
            ingress = it.ingress,
            image = it.image
        )
    }
}

fun Article.asDatabaseModel(): Array<DatabaseArticle> {
    return content.map {
        DatabaseArticle(
            image = it.image,
            title = it.title,
            datetime = it.dateTime,
            ingress = it.ingress
        )
    }.toTypedArray()
}