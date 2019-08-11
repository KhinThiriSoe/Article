package com.khinthirisoe.cararticle.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.khinthirisoe.cararticle.databinding.ListArticleBinding
import com.khinthirisoe.cararticle.domain.ArticleContent

class ArticleAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<ArticleContent, ArticleAdapter.ArticleViewHolder>(DiffCallback) {

    class ArticleViewHolder(private var binding: ListArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(articleContent: ArticleContent) {
            binding.article = articleContent
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ArticleContent>() {
        override fun areItemsTheSame(oldItem: ArticleContent, newItem: ArticleContent): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ArticleContent, newItem: ArticleContent): Boolean {
            return oldItem.image == newItem.image
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        return ArticleViewHolder(ListArticleBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articleContent = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(articleContent)
        }
        holder.bind(articleContent)
    }

    class OnClickListener(val clickListener: (articleContent: ArticleContent) -> Unit) {
        fun onClick(articleContent: ArticleContent) = clickListener(articleContent)
    }
}