package com.khinthirisoe.cararticle.ui.overview

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.khinthirisoe.cararticle.R
import com.khinthirisoe.cararticle.databinding.ListArticleBinding

class OverviewViewHolder(var binding: ListArticleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.list_article
    }
}