package com.khinthirisoe.cararticle.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khinthirisoe.cararticle.domain.ArticleContent

class DetailViewModel(articleContent: ArticleContent, app: Application) : AndroidViewModel(app) {
    private val _selectedContent = MutableLiveData<ArticleContent>()

    val selectedContent: LiveData<ArticleContent>
        get() = _selectedContent

    init {
        _selectedContent.value = articleContent

    }
}
