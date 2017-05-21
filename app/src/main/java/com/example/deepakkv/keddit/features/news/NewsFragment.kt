package com.example.deepakkv.keddit.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.deepakkv.keddit.R
import com.example.deepakkv.keddit.commons.RedditNewsItem
import com.example.deepakkv.keddit.commons.extensions.inflate
import com.example.deepakkv.keddit.features.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment() {

    private val newsList by lazy {
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return container?.inflate(R.layout.fragment_news)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newsList.setHasFixedSize(true)
        newsList.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            (newsList.adapter as NewsAdapter).addNews(mockNews())
        }
    }

    fun initAdapter() {
        if (newsList.adapter == null) {
            newsList.adapter = NewsAdapter()
        }
    }

    fun mockNews(): MutableList<RedditNewsItem> {
        val news = mutableListOf<RedditNewsItem>()
        for (i in 1..10) {
            news.add(RedditNewsItem(
                    author = "author$i",
                    title = "title$i",
                    numComments = i,
                    created = 145720770L - i *200,
                    thumbnail = "http://lorempixel.com/200/200/technics/$i",
                    url = "url"
            ))
        }
        return news
    }

}