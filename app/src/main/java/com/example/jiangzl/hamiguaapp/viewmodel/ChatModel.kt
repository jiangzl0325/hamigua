package com.example.jiangzl.hamiguaapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.jiangzl.hamiguaapp.db.entity.ChatEntity

/**
 * Created by jiangzl on 2018/12/13.
 */
class ChatModel : ViewModel(){

    val chatModel : MutableLiveData<ChatEntity> by lazy {
        MutableLiveData<ChatEntity>()
    }
}