package com.ivanebernal.concertsapp.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivanebernal.concertsapp.R
import com.ivanebernal.concertsapp.events.models.Event
import com.ivanebernal.concertsapp.utils.DateTimeUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.concert_venue_view.view.*

class ConcertsAdapter(private val listener: ConcertSelectedListener): RecyclerView.Adapter<ConcertsAdapter.ConcertViewHolder>() {

    private val concerts: MutableList<Event> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcertViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.concert_venue_view, parent, false)
        return ConcertViewHolder(view)
    }

    override fun getItemCount(): Int {
        return concerts.size
    }

    override fun onBindViewHolder(holder: ConcertViewHolder, position: Int) {
        holder.bindView(concerts[position])
    }

    fun update(concerts: List<Event>) {
        this.concerts.clear()
        this.concerts.addAll(concerts)
        notifyDataSetChanged()
    }

    inner class ConcertViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(concert: Event) {
            itemView.apply {
                concert.images?.last()?.let { Picasso.get().load(it.url).fit().centerCrop().into(concert_image) }
                concert_name.text = concert.name
                val concertDate = concert.dates?.start?.dateTime
                concertDate?.let {
                    time.text = DateTimeUtils.dateTimeStringToDisplayDateTime(it)
                }
                if (concertDate == null) {
                    time.visibility = View.GONE
                }

                val concertVenue = concert._embedded?.venues?.first()
                concertVenue?.let {
                    venue.text = it.name
                    val cityName = if (it.state != null) "${it.city?.name}, ${it.state.stateCode}" else it.city?.name
                    city.text = cityName
                }

                setOnClickListener {
                    listener.onConcertSelected(concert)
                }
            }
        }
    }

    interface ConcertSelectedListener {
        fun onConcertSelected(concert: Event)
    }
}