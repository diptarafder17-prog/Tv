package com.yourorg.openlivetv

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
  private lateinit var web: WebView
  // Replace with your hosted landing page URL after publishing the site
  private val LANDING = "https://yourusername.github.io/open-live-tv/"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    web = WebView(this)
    setContentView(web)

    val ws: WebSettings = web.settings
    ws.javaScriptEnabled = true
    ws.domStorageEnabled = true
    ws.useWideViewPort = true
    ws.loadWithOverviewMode = true

    web.webViewClient = WebViewClient()
    web.webChromeClient = WebChromeClient()
    web.loadUrl(LANDING)
  }

  override fun onBackPressed() {
    if (web.canGoBack()) web.goBack() else super.onBackPressed()
  }
}
