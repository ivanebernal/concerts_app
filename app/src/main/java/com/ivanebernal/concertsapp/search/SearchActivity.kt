package com.ivanebernal.concertsapp.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ivanebernal.concertsapp.R
import kotlinx.android.synthetic.main.activity_main.*

class SearchActivity : AppCompatActivity() {
    private lateinit var model: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupObservers()
        setupViews()
    }

    private fun setupViews() {
        artist_search.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                setLoading(true)
                query?.let { model.performSearch(it) }
                artist_search.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //TODO: implement suggestions
                return false
            }
        })
    }

    private fun setupObservers() {
        model = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        model.getResults()
            .observe(this, Observer { attractions ->
                //TODO: Implement error
                val intent = Intent(this, ResultsActivity::class.java)
                intent.putParcelableArrayListExtra(ResultsActivity.ATTRACTIONS_EXTRA, ArrayList(attractions))
                intent.putExtra(ResultsActivity.QUERY_EXTRA, artist_search.query)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            })
    }

    private fun setLoading(isLoading: Boolean) {
        progress.visibility = if (isLoading) View.VISIBLE else View.GONE
        artist_search.isEnabled = !isLoading
    }
}
