package com.khinthirisoe.cararticle.ui.details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khinthirisoe.cararticle.domain.ArticleContent

class DetailViewModelFactory(
    private val articleContent: ArticleContent,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(articleContent, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
