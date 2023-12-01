package com.example.a1stlab

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class SiteActivity : AppCompatActivity() {
    private lateinit var web:WebView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site)
        web=findViewById(R.id.webView)
        var intent= intent.extras
        if (intent != null) {
            web.loadUrl(intent.getString("site",""))
        }
    }
}