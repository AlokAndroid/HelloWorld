package com.avr.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val counter: Int = getCounter()
    private var message: String? = "not null"
    var listOut: List<Int>? = null
    var myTextView:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message =  message?:"elvis"//getMyMessage()
        listOut =  ArrayList()
        myTextView = findViewById(R.id.my_text_input)
        val series = getFibOutputLoop(counter)
        for((position, item) in series.withIndex()){
            //message += "${getFibOutputRecursive(position-1)}, "
            message += "$item position $position, "
        }
        myTextView?.text = message

    }

    fun getMyMessage(): String{
        var msg = "wrong counter"
        if(counter < 0){
            msg = "value can not be negative"
        }
        else if(counter > 5){
            msg = "value can not be more than five"
        }
        else{
            msg = "value is $counter"
        }
        /*for(i in 0..counter){
            msg += " $i"
        }*/
        var i=0
        while(i < counter){
            msg += " $i"
            i++
        }

        return "message from function where counter is ${getMessageOnWhen(counter)}"
    }
}

fun getMessageOnWhen(input:Int): String {
    return when{
        input < 0 -> "value can not be more than five"
        input > 5 -> "value can not be more than five"
        else -> "value is $input"
    }
}