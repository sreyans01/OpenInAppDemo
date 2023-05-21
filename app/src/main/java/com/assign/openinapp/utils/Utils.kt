package com.assign.openinapp.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.core.content.ContextCompat

object Utils {

    fun Long.toTimeAgo(): Double {
        val time = this
        val now = System.currentTimeMillis()

        // convert back to second
        val diff = (now - time).toDouble() / 1000

        return diff
    }

    fun Context.copyToClipboard(text: CharSequence){
        val clipboard = ContextCompat.getSystemService(this, ClipboardManager::class.java)
        clipboard?.setPrimaryClip(ClipData.newPlainText("",text))
    }

}