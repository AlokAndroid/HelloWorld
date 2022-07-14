package com.avr.training

open class Triangle(side1: Int, side2: Int, side3: Int) {

    constructor(): this(0, 0, 0)

    var mSide1: Int = side1
    var mSide2: Int = side2
    var mSide3: Int = side3
    val mName: String

    init {
        mName = "triangle"
        sTypeOfShape = mName
    }

    companion object{
        var sTypeOfShape = "triangle"
    }

    override fun equals(other: Any?): Boolean {
        if(other != null && other is Triangle){
          return (mSide1 == other!!.mSide1) and (mSide2 == other!!.mSide2) and (mSide3 == other!!.mSide3)
        }
        return false
    }
}