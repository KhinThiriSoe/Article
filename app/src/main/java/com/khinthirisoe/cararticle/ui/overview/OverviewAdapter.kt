package com.khinthirisoe.cararticle.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.khinthirisoe.cararticle.databinding.ListArticleBinding
import com.khinthirisoe.cararticle.domain.ArticleContent

class OverviewAdapter(val onClickListener: OverviewFragment) :
    RecyclerView.Adapter<OverviewViewHolder>() {

    var articleContentLists: List<ArticleContent> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        val withDataBinding: ListArticleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            OverviewViewHolder.LAYOUT,
            parent,
            false)
        return OverviewViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        holder.binding.also {
            it.article = articleContentLists[position]
        }
    }

    override fun getItemCount(): Int {
        return articleContentLists.size
    }

    class OnClickListener(val clickListener: (articleContent: ArticleContent) -> Unit) {
        fun onClick(articleContent: ArticleContent) = clickListener(articleContent)
    }
}