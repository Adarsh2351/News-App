package com.adarsh.newsapp.fragments.country

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adarsh.newsapp.ConnectionManager
import com.adarsh.newsapp.NewsItemClicked
import com.adarsh.newsapp.NewsListAdapter
import com.adarsh.newsapp.R
import com.adarsh.newsapp.activity.News
import com.android.volley.AuthFailureError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class SaudiArabiaFragment : Fragment(), NewsItemClicked {
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: NewsListAdapter


    private val newsList: MutableList<News> = mutableListOf()
    private var currentPage = 1
    private var isLoading = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_saudi_arabia, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        progressBar = view.findViewById(R.id.progress_circular)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = NewsListAdapter(this)
        recyclerView.adapter = adapter



        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (!isLoading && visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                    loadMoreNews()
                }
            }
        })

        loadNews()

        return view
    }

    private fun loadNews() {
        if (ConnectionManager().checkConnectivity(activity as Context)) {

            progressBar.visibility = View.VISIBLE
            val queue = Volley.newRequestQueue(activity as Context)
            val url =
                "https://newsapi.org/v2/everything?q=saudi-arabia&sortBy=relevancy&pageSize=100&apiKey=6bd4aa0c38264f7b9ff034995a0c7329"

            val jsonObjectRequest = object : JsonObjectRequest(
                Method.GET, url, null,
                { response ->
                    try {
                        val newArticles = parseResponse(response)
                        newsList.addAll(newArticles)
                        adapter.setData(newsList as ArrayList<News>)
                        isLoading = false
                        progressBar.visibility = View.GONE
                    } catch (e: JSONException) {
                        Toast.makeText(
                            activity as Context,
                            "Some unexpected error occured",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                },
                { error ->
                    isLoading = false
                    Toast.makeText(activity as Context, "Something went wrong", Toast.LENGTH_LONG)
                        .show()
                }
            ) {
                @Throws(AuthFailureError::class)
                override fun getHeaders(): Map<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    params["User-Agent"] = "Mozilla/5.0"
                    return params
                }
            }
            queue.add(jsonObjectRequest)
        } else {
            val dialog = AlertDialog.Builder(activity as Context)
            dialog.setTitle("Error")
            dialog.setMessage("Internet Connection is not Found")
            dialog.setPositiveButton("Open Settings") { _, _ ->
                val settingsIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingsIntent)
                activity?.finish()
            }
            dialog.setNegativeButton("Cancel") { _, _ ->
                ActivityCompat.finishAffinity(activity as Activity)
            }
            dialog.create()
            dialog.show()
        }
    }

    fun parseResponse(response: JSONObject): List<News> {
        val response = response.getJSONArray("articles")
        val newArticles: MutableList<News> = mutableListOf()
        for (i in 0 until response.length()) {
            val articleJson = response.getJSONObject(i)
            val title = articleJson.getString("title")
            val author = articleJson.getString("author")
            val url = articleJson.getString("url")
            val imageUrl = articleJson.getString("urlToImage")

            val newsArticle = News(title, author, url, imageUrl)
            newArticles.add(newsArticle)
        }

        return newArticles
    }

    private fun loadMoreNews() {
        if (isLoading) return

        isLoading = true
        currentPage++
        loadNews()
    }

    override fun onItemClicked(item: News) {
        val intent = CustomTabsIntent.Builder()
            .build()
        intent.launchUrl(activity as Context, Uri.parse(item.url))
    }

}