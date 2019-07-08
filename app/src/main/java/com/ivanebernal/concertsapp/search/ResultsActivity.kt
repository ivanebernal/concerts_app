package com.ivanebernal.concertsapp.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ivanebernal.concertsapp.R
import com.ivanebernal.concertsapp.events.EventsActivity
import com.ivanebernal.concertsapp.search.models.Attraction
import com.ivanebernal.concertsapp.utils.NoResultIconUtils
import kotlinx.android.synthetic.main.activity_results.*
import kotlinx.android.synthetic.main.no_results_view.*
import kotlinx.android.synthetic.main.no_results_view.view.*

class ResultsActivity : AppCompatActivity(), ArtistsAdapter.ArtistSelectionListener {

    lateinit var model: SearchViewModel
    private val artistAdapter = ArtistsAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        setupObservers()
        setupViews()
    }

    private fun setupObservers() {
        model = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        model.getResults().observe(this, Observer {
            setLoading(false)
            if (it.isNullOrEmpty()) no_result_view.visibility = View.VISIBLE
            artistAdapter.replaceAll(it)
        })
    }

    private fun setupViews() {
        setupNoResultView()
        setupArtistList()
        setupSearchView()
    }

    private fun setupSearchView() {
        val query = intent.getStringExtra(QUERY_EXTRA)
        artist_search.setQuery(query, false)
        artist_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { model.performSearch(query) }
                no_result_view.visibility = View.GONE
                setLoading(true)
                artist_search.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //TODO: implement suggestions
                return false
            }
        })
    }

    private fun setupArtistList() {
        val layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        val initialArtists = intent.getParcelableArrayListExtra<Attraction>(ATTRACTIONS_EXTRA)
        rv_artist.adapter = artistAdapter
        rv_artist.layoutManager = layoutManager
        if (!initialArtists.isNullOrEmpty()) {
            artistAdapter.replaceAll(initialArtists)
        } else {
            no_result_view.visibility = View.VISIBLE
        }
    }

    private fun setupNoResultView() {
        no_result_view.no_result_image.setImageResource(NoResultIconUtils.getRandomIconId())
        val noResultMessage = "No artist found"
        no_result_text.text = noResultMessage
    }

    private fun setLoading(isLoading: Boolean) {
        progress.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onArtistSelected(artist: Attraction) {
        val intent = Intent(this, EventsActivity::class.java)
        intent.putExtra(EventsActivity.ARTIST_EXTRA, artist)
        startActivity(intent)
    }

    companion object {
        val ATTRACTIONS_EXTRA = "attractions_extra"
        val QUERY_EXTRA = "query_extra"
    }
}
