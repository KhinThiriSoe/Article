package com.khinthirisoe.cararticle.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.RecyclerView
import com.khinthirisoe.cararticle.databinding.ListArticleBinding
import com.khinthirisoe.cararticle.domain.ArticleContent

class ArticleAdapter(val callback: ArticleClick) : RecyclerView.Adapter<ArticleViewHolder>() {

    var articles: List<ArticleContent> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val withDataBinding: ListArticleBinding = inflate(
            LayoutInflater.from(parent.context),
            ArticleViewHolder.LAYOUT,
            parent,
            false)
        return ArticleViewHolder(withDataBinding)
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.article = articles[position]
        }
    }

}

