package kr.wayde.githubsearch.util

import android.util.Log

class Logger {

    fun d(t: Throwable) {
        t.printStackTrace()
        Log.e("e",t.toString())
    }
}
