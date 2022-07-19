package com.avr.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val counter: Int = getCounter()
    private var message: String? = "not null"
    var listOut: List<Int>? = null
    private var myTextView:TextView? = null
    var editText:EditText? = null
    var triangle1:RightTriangle? = null
    var triangle2:RightTriangle? = null
    var triangle3:RightTriangle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        setContentView(R.layout.activity_main)
        message =  message?:"elvis"//getMyMessage()
        listOut =  ArrayList()
        myTextView = findViewById(R.id.my_text_input)
        editText = findViewById(R.id.txt_input_view)
        findViewById<Button>(R.id.btn_read_input).setOnClickListener {
            onButtonClick(it)
        }
        val series = getFibOutputLoop(counter)
        for((position, item) in series.withIndex()){
            //message += "${getFibOutputRecursive(position-1)}, "
            message += "$item position $position, "
        }
        myTextView?.text = message
        triangle1 = RightTriangle(8, 8)
        triangle2 = RightTriangle(8, 8)
        triangle3 = triangle1
        if(triangle1 == triangle2){
            Log.d(TAG, "value equal triangle1 == triangle2")
        }
        if(triangle1 === triangle2){
            Log.d(TAG, "reference equal triangle1 == triangle2")
        }
        if(triangle1 === triangle3){
            Log.d(TAG, "reference equal triangle1 == triangle3")
        }
        //myTextView?.setOnTouchListener()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
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

    fun onButtonClick(view: View){
        myTextView?.text = editText?.text
    }

    companion object{
        private val TAG = "HELLO_WORLD"
    }
}

fun getMessageOnWhen(input:Int): String {
    return when{
        input < 0 -> "value can not be more than five"
        input > 5 -> "value can not be more than five"
        else -> "value is $input"
    }
}