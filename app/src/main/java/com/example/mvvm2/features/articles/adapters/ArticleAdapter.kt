package com.example.mvvm2.features.articles.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm2.databinding.ArticleCardBinding
import com.example.mvvm2.features.articles.ui.ArticleListFragmentDirections.Companion.actionArticleListToArticleDetails
import com.example.mvvm2.features.model.topNews.TopNewsModel


class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {


    private lateinit var articles: List<TopNewsModel>

    fun setArticles(articles: List<TopNewsModel>) {
        this.articles = articles
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleCardBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val article = articles[position]
        holder.binding.articleTitle.text = article.title
        holder.binding.articleDescription.text = article.description
        Glide.with(holder.itemView.context).load(article.urlToImage)
            .into(holder.binding.articleImage)

        holder.binding.articleImage.setOnClickListener {
            val webView = WebView(holder.itemView.context)
            webView.loadUrl(article.url)}

            holder.binding.root.setOnClickListener {

                val action = actionArticleListToArticleDetails(holder.binding.articleTitle.text.toString(),holder.binding.articleDescription.text.toString(),article.urlToImage,article.url)
                findNavController(holder.itemView).navigate(action)



            }
        }






    override fun getItemCount(): Int {
        return articles.size
    }


    class ArticleViewHolder(val binding: ArticleCardBinding) : RecyclerView.ViewHolder(binding.root)




}




