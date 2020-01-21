package ru.agatech.mkprsm.ui

import android.graphics.Bitmap
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.*
import kotlinx.android.synthetic.main.activity_web.*
import ru.agatech.mkprsm.R

class WEb : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webreg.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                webreg.loadUrl("https://mkp-ruy.ru/card")
                webreg.settings.javaScriptEnabled
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                webreg.clearCache(true)
            }

            override fun onPageCommitVisible(view: WebView?, url: String?) {
                super.onPageCommitVisible(view, url)
            }

            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler?,
                error: SslError?
            ) {
                Log.e("Tag","OnReceivedSslError chat ::: ")
                super.onReceivedSslError(view, handler, error)
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                webreg.stopLoading()
                super.onReceivedError(view, request, error)
            }

            @SuppressWarnings("deprecation")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                Log.e("TAG", "currentUrl ::: " + url)
                webreg.loadUrl(url)
                return super.shouldOverrideUrlLoading(view, url)
            }
        }
        webreg.loadUrl("https://mkp-ruy.ru/card")
    }
}
