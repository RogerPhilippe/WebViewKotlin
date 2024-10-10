package br.com.philippesis.webviewkotlin

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webview)

        val htmlContent = readHtmlContent(this)

        if (htmlContent.isEmpty() || htmlContent.isBlank()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
        } else {
            webView.settings.javaScriptEnabled = true
            webView.loadDataWithBaseURL("file:///android_asset", htmlContent, "text/html", "UTF-8", null)
        }

    }

    private fun readHtmlContent(context: Context): String {
        return try {
            context.assets.open("index.html").bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            Log.e("Error", "Error trying read HTML file", e)
            ""
        }
    }

}
