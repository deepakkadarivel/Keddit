package com.example.deepakkv.keddit.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.deepakkv.keddit.R
import com.example.deepakkv.keddit.commons.RedditNewsItem
import com.example.deepakkv.keddit.commons.extensions.getFriendlyTime
import com.example.deepakkv.keddit.commons.extensions.inflate
import com.example.deepakkv.keddit.commons.extensions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class NewsViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(parent.inflate(R.layout.news_item)) {
        fun bind(item: RedditNewsItem) = with(itemView) {
            img_thumbnail.loadImg(item.thumbnail)
            author.text = item.author
            description.text = item.title
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }

}
