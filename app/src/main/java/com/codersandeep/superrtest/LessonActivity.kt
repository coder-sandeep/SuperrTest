package com.codersandeep.superrtest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codersandeep.superrtest.utils.Constants
import com.codersandeep.superrtest.utils.PreferenceManager


class LessonActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var webView: WebView
    lateinit var floatingButton : Button
    var cardId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        cardId = intent.getIntExtra("cardId",0)

        webView = findViewById(R.id.main_webview)
        floatingButton = findViewById(R.id.floating_button)
        floatingButton.setOnClickListener(this)

        // Enable JavaScript in the WebView
        webView.settings.javaScriptEnabled = true

        // Set up a WebViewClient to load the web page
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                // Execute JavaScript code to log a message
                webView.loadUrl("""
                    javascript:(setTimeout(function() {
                        document.body.addEventListener("click",function(){Bridge.logMessage(document.getElementsByClassName("progress")[0].style.width)})
                    },1000))()
                    """.trimIndent())
                Log.d(Constants.LOGTAG, "loaded")
            }
        }

        webView.addJavascriptInterface(JavaScriptInterface(this),"Bridge")

        // Load a web page
        webView.loadUrl(intent.getStringExtra("URL")!!) // Replace with the URL you want to load
    }

    class JavaScriptInterface(private val activity: LessonActivity) {
        @JavascriptInterface
        fun logMessage(message: String) {
            Log.d(Constants.LOGTAG,message)
            if (message == "100%") {
                Toast.makeText(activity,"Lesson completed, CardID saved",Toast.LENGTH_SHORT).show()
                activity.runOnUiThread {
                    activity.floatingButton.visibility = View.VISIBLE
                    activity.saveToShared()
                }
            }
        }
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this,MainActivity :: class.java))
    }

    fun saveToShared(){
        val mArray = intArrayOf(cardId)

        PreferenceManager().saveIntArrayToSharedPreferences(applicationContext, Constants.SHARED_PREF_KEY, mArray)
    }
}
//document.getElementsByClassName("progress")[0].style.width