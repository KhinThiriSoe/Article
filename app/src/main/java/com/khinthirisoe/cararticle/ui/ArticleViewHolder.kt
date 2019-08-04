package com.khinthirisoe.cararticle.ui

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.khinthirisoe.cararticle.R
import com.khinthirisoe.cararticle.databinding.ListArticleBinding

class ArticleViewHolder(val viewDataBinding: ListArticleBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.list_article
    }
}