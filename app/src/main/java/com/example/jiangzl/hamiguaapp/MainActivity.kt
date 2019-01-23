package com.example.jiangzl.hamiguaapp

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.Spanned
import android.view.View
import com.example.jiangzl.hamiguaapp.R
import com.example.jiangzl.hamiguaapp.ui.ChatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.URL

/**
 * Created by jiangzl on 2018/12/13.
 */
class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_chat.setOnClickListener(View.OnClickListener {
            startActivity(Intent(MainActivity@this,ChatActivity::class.java))
        })
        val html = "<font style='color:#fed3b2 ;font-size:12'>CNY388</font>" + "<img src='https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=686476135,742078865&fm=173&app=25&f=JPG?w=218&h=146&s=ED2DB0541A0A1555C44AAF810300308E' />";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val  sp : Spanned = Html.fromHtml(html,1,object : Html.ImageGetter{
                override fun getDrawable(source: String?): Drawable? {
                    var iss : InputStream? = null;
                    try {
                        iss = URL(source).getContent() as InputStream;
                        val  d = Drawable.createFromStream(iss, "src");
                        d.setBounds(0, 0, d.getIntrinsicWidth(),
                                d.getIntrinsicHeight());
                        iss.close();
                        return d;
                    } catch (e : Exception){

                    }
                    return null

                }

            },null)
            bt_chat.text = sp
        }
    }
}