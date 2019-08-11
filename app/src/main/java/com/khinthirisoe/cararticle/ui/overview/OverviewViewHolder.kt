package com.khinthirisoe.cararticle.ui.overview

import androidx.recyclerview.widget.RecyclerView
import com.khinthirisoe.cararticle.databinding.ListArticleBinding
import com.khinthirisoe.cararticle.domain.ArticleContent

class OverviewViewHolder(private var binding: ListArticleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(articleContent: ArticleContent) {
        binding.article = articleContent
        binding.executePendingBindings()
    }
}