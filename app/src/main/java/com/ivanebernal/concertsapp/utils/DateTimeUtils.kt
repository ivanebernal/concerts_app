package com.ivanebernal.concertsapp.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class DateTimeUtils {
    companion object {
        fun dateTimeStringToDisplayDateTime(dateTime: String): String {
            return parseDateTime(dateTime, "MM/dd/yy HH:mm a")
        }

        fun dateTimeStringToDisplayDate(dateTime: String): String {
            return parseDateTime(dateTime, "MM/dd/yy")
        }

        fun dateTimeStringToDisplayTime(dateTime: String): String {
            return parseDateTime(dateTime, "HH:mm a")
        }

        private fun parseDateTime(dateTime: String, out: String): String {
            val inFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val outFormat = SimpleDateFormat(out, Locale.getDefault())
            return try {
                val date = inFormat.parse(dateTime.replace("Z$", "+0000"))
                outFormat.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
                ""
            }
        }
    }
}