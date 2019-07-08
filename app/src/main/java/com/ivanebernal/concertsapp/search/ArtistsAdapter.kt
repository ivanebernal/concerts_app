package com.ivanebernal.concertsapp.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivanebernal.concertsapp.R
import com.ivanebernal.concertsapp.search.models.Attraction
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.artist_result_view.view.*

class ArtistsAdapter(private val listener: ArtistSelectionListener): RecyclerView.Adapter<ArtistsAdapter.ArtistViewHolder>() {

    private val artists: MutableList<Attraction> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.artist_result_view, parent, false)
        return ArtistViewHolder(view)
    }

    override fun getItemCount(): Int {
        return artists.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bindData(artists[position])
    }

    fun replaceAll(artists: List<Attraction>) {
        this.artists.clear()
        this.artists.addAll(artists)
        notifyDataSetChanged()
    }

    fun addItems(artists: List<Attraction>) {
        val startIndex = this.artists.size
        this.artists.addAll(artists)
        notifyItemRangeInserted(startIndex, this.artists.size)
    }

    inner class ArtistViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindData(artist: Attraction) {
            itemView.apply {
                artist.images?.last()?.let { Picasso.get().load(it.url).fit().centerCrop().into(artist_picture) }
                artist_name.text = artist.name
                setOnClickListener { listener.onArtistSelected(artist) }
            }
        }
    }

    interface ArtistSelectionListener {
        fun onArtistSelected(artist: Attraction)
    }
}