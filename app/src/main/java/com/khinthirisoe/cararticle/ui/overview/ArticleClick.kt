package com.khinthirisoe.cararticle.ui.overview

import com.khinthirisoe.cararticle.domain.ArticleContent

class ArticleClick(val block: (ArticleContent) -> Unit) {
    fun onClick(articleContent: ArticleContent) = block(articleContent)
}
