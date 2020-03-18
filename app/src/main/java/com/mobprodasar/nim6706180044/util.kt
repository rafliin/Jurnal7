package com.mobprodasar.nim6706180044

import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.mobprodasar.nim6706180044.database.DataMasukan
import java.lang.StringBuilder

fun ShowDataSemua(dataData: List<DataMasukan>): Spanned {
    val sb = StringBuilder()

    sb.apply {
        dataData.forEach{
            append("${it.teks}<br>")
        }
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}