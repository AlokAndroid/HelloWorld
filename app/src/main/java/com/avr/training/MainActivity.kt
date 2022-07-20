package com.avr.training

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_BUTTON_PRESS
import android.view.MotionEvent.ACTION_DOWN
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.NumberFormatException

@SuppressLint("ClickableViewAccessibility")
class MainActivity : AppCompatActivity() {
    val counter: Int = getCounter()
    private var message: String? = "not null"
    var listOut: List<Int>? = null
    private var myTextView:TextView? = null
    private var editText:EditText? = null
    var touchContainer:View? = null
    var triangle1:RightTriangle? = null
    var triangle2:RightTriangle? = null
    var triangle3:RightTriangle? = null
    lateinit var listView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        setContentView(R.layout.activity_main)
        message =  message?:"elvis"//getMyMessage()
        listOut =  ArrayList()
        myTextView = findViewById(R.id.my_text_input)
        editText = findViewById(R.id.txt_input_view)
        touchContainer = findViewById(R.id.touch_area)
        listView = findViewById(R.id.list_view)
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
        touchContainer?.setOnTouchListener{ view: View, motionEvent: MotionEvent ->
            onMyAreaTouch(view, motionEvent)
        }
        listView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
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

    private fun onButtonClick(view: View){
        myTextView?.text = editText?.text
        var size: Int? = null
        try {
            size = editText?.text?.toString()?.toInt()
        }
        catch (ex: NumberFormatException){
            Log.e(TAG, "$ex")
        }
        size?.let{
            val data = getListData(it)
            Log.d(TAG, "data size ${data.size}")
            val adapter = MyAdapter(data, this)
            listView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

    private fun onMyAreaTouch(touchView: View, touchType: MotionEvent): Boolean{
        return when(touchType.action){
            ACTION_DOWN -> {
                myTextView?.text = "touch point is x ${touchType.x}, y ${touchType.y}"
                Log.d(TAG, "action down event ${touchType.action} touch point x ${touchType.x}, y ${touchType.y}")
                true
            }
            else -> {
                Log.d(
                    TAG,
                    "other event ${touchType.action} touch point x ${touchType.x}, y ${touchType.y}"
                )
                false
            }
        }
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