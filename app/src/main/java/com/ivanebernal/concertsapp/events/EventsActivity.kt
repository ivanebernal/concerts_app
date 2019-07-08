package com.ivanebernal.concertsapp.events

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanebernal.concertsapp.R
import com.ivanebernal.concertsapp.details.ConcertDetailsActivity
import com.ivanebernal.concertsapp.events.models.Event
import com.ivanebernal.concertsapp.search.models.Attraction
import com.ivanebernal.concertsapp.utils.NoResultIconUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_events.*
import kotlinx.android.synthetic.main.no_results_view.view.*

class EventsActivity : AppCompatActivity(), ConcertsAdapter.ConcertSelectedListener {

    lateinit var model: EventsViewModel
    private val adapter = ConcertsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        setupObservables()
        setupViews()
    }

    private fun setupObservables() {
        model = ViewModelProviders.of(this).get(EventsViewModel::class.java)
        model.getEvents().observe(this, Observer {
            setEmptyResult(it.isEmpty())
            adapter.update(it)
            setLoading(false)
        })
    }

    private fun setEmptyResult(isEmpty: Boolean) {
        no_result.visibility = if (isEmpty) View.VISIBLE else View.GONE
    }

    private fun setupViews() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val artist = intent.getParcelableExtra<Attraction>(ARTIST_EXTRA)
        artist.images?.last()?.let { Picasso.get().load(it.url).fit().centerCrop().into(background) }
        val noResultText = "No concerts found for ${artist.name}"
        no_result.no_result_text.text = noResultText
        no_result.no_result_image.setImageResource(NoResultIconUtils.getRandomIconId())
        supportActionBar?.title = artist.name
        concerts.layoutManager = LinearLayoutManager(this)
        concerts.adapter = adapter
        model.fetchEvents(artist.id)
        setLoading(true)
    }

    private fun setLoading(isLoading: Boolean) {
        progress.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onConcertSelected(concert: Event) {
        val intent = Intent(this, ConcertDetailsActivity::class.java)
        intent.putExtra(ConcertDetailsActivity.EXTRA_CONCERT_DETAILS, concert)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        val ARTIST_EXTRA = "artist_extra"
    }
}
