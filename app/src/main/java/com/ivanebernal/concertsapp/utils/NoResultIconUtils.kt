package com.ivanebernal.concertsapp.utils

import com.ivanebernal.concertsapp.R

class NoResultIconUtils {
    companion object {
        private val icons = arrayOf(
            R.drawable.ic_dj,
            R.drawable.ic_drummer,
            R.drawable.ic_electric_guitar,
            R.drawable.ic_piano,
            R.drawable.ic_singer,
            R.drawable.ic_violoncello
        )

        fun getRandomIconId(): Int {
            val index = (0 until icons.size).random()
            return icons[index]
        }
    }
}