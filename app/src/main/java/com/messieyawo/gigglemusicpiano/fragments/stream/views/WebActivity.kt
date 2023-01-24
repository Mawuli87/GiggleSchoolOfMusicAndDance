package com.messieyawo.gigglemusicpiano.fragments.stream.views
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.messieyawo.gigglemusicpiano.R


class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

       // val toolbar: Toolbar = findViewById(R.id.web_toolbar)
      //  setSupportActionBar(toolbar)
      //  supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //getSupportActionBar().setDisplayShowHomeEnabled(true);


        //getSupportActionBar().setDisplayShowHomeEnabled(true);
       // setSupportActionBar(toolbar)
        //toolbar.setLogo(R.drawable.ic_online);
        //toolbar.setLogo(R.drawable.ic_online);
        val webView = findViewById<WebView>(R.id.web)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://giggleschoolofmusicanddance.com/")
    }
}