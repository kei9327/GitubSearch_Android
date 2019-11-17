package kr.wayde.githubsearch.util

import java.text.DecimalFormat

fun formatFileSize(size: Long): String? {
    var hrSize: String? = null

    val b = size.toDouble()
    val k = size / 1024.0
    val m = size / 1024.0 / 1024.0
    val g = size / 1024.0 / 1024.0 / 1024.0
    val t = size / 1024.0 / 1024.0 / 1024.0 / 1024.0

    val dec = DecimalFormat("0.00")

    if (t > 1) {
        hrSize = dec.format(t).plus(" TB")
    } else if (g > 1) {
        hrSize = dec.format(g).plus(" GB")
    } else if (m > 1) {
        hrSize = dec.format(m).plus(" MB")
    } else if (k > 1) {
        hrSize = dec.format(k).plus(" KB")
    } else {
        hrSize = dec.format(b).plus(" Bytes")
    }

    return hrSize
}