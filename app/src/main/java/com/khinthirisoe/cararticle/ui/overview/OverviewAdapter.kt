package com.khinthirisoe.cararticle.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.khinthirisoe.cararticle.databinding.ListArticleBinding
import com.khinthirisoe.cararticle.domain.ArticleContent

class OverviewAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<ArticleContent, OverviewViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OverviewViewHolder {
        return OverviewViewHolder(ListArticleBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        val articleContent = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(articleContent)
        }
        holder.bind(articleContent)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ArticleContent>() {
        override fun areItemsTheSame(oldItem: ArticleContent, newItem: ArticleContent): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ArticleContent, newItem: ArticleContent): Boolean {
            return oldItem.image == newItem.image
        }
    }

    class OnClickListener(val clickListener: (articleContent: ArticleContent) -> Unit) {
        fun onClick(articleContent: ArticleContent) = clickListener(articleContent)
    }
}