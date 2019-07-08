package com.ivanebernal.concertsapp.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ivanebernal.concertsapp.R
import com.ivanebernal.concertsapp.events.models.Event
import com.ivanebernal.concertsapp.events.models.Venue
import com.ivanebernal.concertsapp.utils.DateTimeUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_concert_details.*

class ConcertDetailsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var concert: Event
    private var venue: Venue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concert_details)
        setupViews()
    }

    private fun setupViews() {
        concert = intent.getParcelableExtra(EXTRA_CONCERT_DETAILS)
        venue = concert._embedded?.venues?.first()
        setupActionBar()
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setVenueInfo()
        setSeatMap()
        setGetTicketsFab()
        setConcertDetails()

    }

    private fun setSeatMap() {
        concert.seatmap?.let { Picasso.get().load(it.staticUrl).into(seatmap) }
        if (concert.seatmap == null) {
            seatmap_title.visibility = View.GONE
            seatmap.visibility = View.GONE
        }
    }

    private fun setGetTicketsFab() {
        if (concert.url == null) get_tickets_fab.hide()
        else {
            get_tickets_fab.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(concert.url))
                startActivity(intent)
            }
        }
    }

    private fun setConcertDetails() {
        if (concert.dates?.start?.dateTime == null) {
            date.visibility = View.GONE
            date_title.visibility = View.GONE
            time.visibility = View.GONE
            time_title.visibility = View.GONE
        }
        concert.dates?.start?.dateTime?.let {
            date.text = DateTimeUtils.dateTimeStringToDisplayDate(it)
            time.text = DateTimeUtils.dateTimeStringToDisplayTime(it)
        }
        val priceRange = concert.priceRanges?.first()
        if (priceRange == null) {
            range.visibility = View.GONE
            range_title.visibility = View.GONE
        }
        val rangeString = "${priceRange?.min} - ${priceRange?.max} ${priceRange?.currency}"
        range.text = rangeString
    }

    private fun setVenueInfo() {
        venue_name.text = venue?.name
        venue_address.text = venue?.address?.line1
        venue_postal_code.text = venue?.postalCode
        venue_city.text =
            if (venue?.state != null)
                "${venue?.city?.name}, ${venue?.state?.stateCode}"
            else
                venue?.city?.name
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        concert_name.text = concert.name
        concert.images?.last()?.let {
            Picasso.get().load(it.url).fit().centerCrop().into(concert_image)
        }
    }

    override fun onMapReady(map: GoogleMap?) {
        val venue = concert._embedded?.venues?.first()
        val lat = venue?.location?.latitude?.toDouble()
        val lng = venue?.location?.longitude?.toDouble()
        if (lat != null && lng != null) {
            val latlng = LatLng(lat, lng)
            map?.addMarker(MarkerOptions().position(latlng).title(venue.name))
            map?.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 16.5F))
        }
        map?.uiSettings?.isScrollGesturesEnabled = false
        map?.uiSettings?.isZoomGesturesEnabled = false
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
        val EXTRA_CONCERT_DETAILS = "extra_concert_details"
    }
}
