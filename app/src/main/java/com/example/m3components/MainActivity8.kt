package com.example.m3components

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.progressindicator.LinearProgressIndicator

class MainActivity8 : AppCompatActivity() {
    private lateinit var webView: WebView
    lateinit var ProgressIndicator: LinearProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        // Initialize views
        webView = findViewById(R.id.webView)
        ProgressIndicator = findViewById(R.id.linearProgressIndicator)

        // Configure WebView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = CustomWebViewClient()
        webView.webChromeClient = CustomWebChromeClient()

        // Load the URL
        webView.loadUrl("https://www.arabbank.jo/")
    }

    inner class CustomWebViewClient : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            // Show the progress indicator when page starts loading
            ProgressIndicator.visibility = View.VISIBLE
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            // Hide the progress indicator when page finishes loading
            ProgressIndicator.visibility = View.GONE
            super.onPageFinished(view, url)
        }
    }

    inner class CustomWebChromeClient : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)

            // Update progress of the progress indicator
            ProgressIndicator.progress = newProgress
        }

    }
}