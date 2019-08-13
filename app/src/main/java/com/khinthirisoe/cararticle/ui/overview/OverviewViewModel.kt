package com.khinthirisoe.cararticle.ui.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khinthirisoe.cararticle.database.getDatabase
import com.khinthirisoe.cararticle.domain.ArticleContent
import com.khinthirisoe.cararticle.repository.ArticleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch



class OverviewViewModel(application: Application) : AndroidViewModel(application) {

    private var _navigateToSelectedArticle = MutableLiveData<ArticleContent>()
    val navigateToSelectedArticle: LiveData<ArticleContent>
        get() = _navigateToSelectedArticle

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val database = getDatabase(application)
    private val articleRepository = ArticleRepository(database)

    init {
        viewModelScope.launch {
            articleRepository.refreshArticles()
        }
    }

    val articleContent = articleRepository.articles

    fun displayContentDetails(articleContent: ArticleContent) {
        _navigateToSelectedArticle.value = articleContent
    }

    fun displayContentDetailsComplete() {
        _navigateToSelectedArticle.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
