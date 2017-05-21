package com.example.deepakkv.keddit.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.deepakkv.keddit.R
import com.example.deepakkv.keddit.commons.extensions.inflate

class LoadingDelegateAdapter: ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading))

}
