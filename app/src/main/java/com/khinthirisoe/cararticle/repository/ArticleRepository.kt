package com.khinthirisoe.cararticle.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.khinthirisoe.cararticle.database.ArticlesDatabase
import com.khinthirisoe.cararticle.database.asDomainModel
import com.khinthirisoe.cararticle.domain.ArticleContent
import com.khinthirisoe.cararticle.network.Network
import com.khinthirisoe.cararticle.network.asDatabaseModel
import com.khinthirisoe.cararticle.ui.connection.InternetUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArticleRepository(private val database: ArticlesDatabase) {

    val articles: LiveData<List<ArticleContent>> = Transformations.map(database.articleDao.getArticles()) {
        it.asDomainModel()
    }

    suspend fun refreshArticles() {
        withContext(Dispatchers.IO) {
            if (InternetUtil.isInternetOn()){
                val article = Network.articleService.getArticleList().await()
                database.articleDao.insertAll(*article.asDatabaseModel())
            }
        }
    }

}