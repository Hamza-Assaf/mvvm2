package com.example.mvvm2.features.articles.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm2.databinding.FragmentArticleDetailsBinding
import com.example.mvvm2.features.model.ArticleModel

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    var articles = mutableListOf<ArticleModel>()
    fun setArticleList(articles: List<ArticleModel>) {
        this.articles = articles.toMutableList()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentArticleDetailsBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val article = articles[position]
        holder.binding.articleTitle.text = article.title
        holder.binding.articleDescription.text = article.description
        Glide.with(holder.itemView.context).load(article.urlToImage)
            .into(holder.binding.articleImage)
    }


    override fun getItemCount(): Int {
        return articles.size
    }


    class ArticleViewHolder(val binding: FragmentArticleDetailsBinding) :
        RecyclerView.ViewHolder(binding.root)


}