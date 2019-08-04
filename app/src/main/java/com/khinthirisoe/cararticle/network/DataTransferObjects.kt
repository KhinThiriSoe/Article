package com.khinthirisoe.cararticle.network

import com.khinthirisoe.cararticle.database.DatabaseArticle
import com.khinthirisoe.cararticle.domain.ArticleContent

data class NetworkContentContainer(val content: List<Content>)

fun NetworkContentContainer.asDomainModel(): List<ArticleContent> {
    return content.map {
        ArticleContent(
            title = it.title,
            datetime = it.dateTime,
            ingress = it.ingress,
            image = it.image
        )
    }
}

fun NetworkContentContainer.asDatabaseModel(): Array<DatabaseArticle> {
    return content.map {
        DatabaseArticle(
            title = it.title,
            datetime = it.dateTime,
            ingress = it.ingress,
            image = it.image
        )
    }.toTypedArray()
}