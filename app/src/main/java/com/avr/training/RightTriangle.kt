package com.avr.training

import java.util.function.Consumer

class RightTriangle(base: Int, perpendicular: Int): Triangle(),Consumer<String>  {

    init {
        mSide1 = base
        mSide2 = perpendicular
        mSide3 = Math.sqrt((base*base + perpendicular*perpendicular).toDouble()).toInt()
    }

    override fun accept(p0: String) {

    }
}