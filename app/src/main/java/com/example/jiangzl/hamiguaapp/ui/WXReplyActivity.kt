package com.example.jiangzl.hamiguaapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.jiangzl.hamiguaapp.R
import okhttp3.*
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit


class WXReplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wxreply)
    }

    var client = OkHttpClient()

    @Throws(IOException::class)
    private fun run(url: String) {
        val request = Request.Builder()
                .url(url)
                .build()

//        client.newCall(request).execute().use { response -> return response.body()?.string() }
        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call?, response: Response?) {
            }

            override fun onFailure(call: Call?, e: IOException?) {
            }

        })
        OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .cache(Cache( File("/haha"),10*10*1024))
                .build()


    }
}
