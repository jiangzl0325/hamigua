package com.example.jiangzl.hamiguaapp.ui

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.jiangzl.hamiguaapp.R
import com.example.jiangzl.hamiguaapp.viewmodel.NameViewModel
import kotlinx.android.synthetic.main.activity_chat.*

/**
 * Created by jiangzl on 2018/12/13.
 */
class ChatActivity : AppCompatActivity(){

    private lateinit var mModel: NameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        // Other code to setup the activity...

        // Get the ViewModel.
        mModel = ViewModelProviders.of(this).get(NameViewModel::class.java)


        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            v_title.subtitle = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.currentName.observe(this, nameObserver)

        bt_action.setOnClickListener({
            mModel.currentName.setValue("而鼻子")        })
    }
}