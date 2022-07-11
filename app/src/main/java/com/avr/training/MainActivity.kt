package com.avr.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val counter: Int = getCounter()
    private var message: String? = "Hello"
    var listOut: List<Int>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message = getMyMessage()
        listOut =  ArrayList()
    }

    fun getMyMessage(): String{
        return "message from function"
    }
}