package com.avr.training


fun getCounter() : Int{
    return 5
}

fun getFibOutputRecursive(input: Int): Int{

    return if(input <= 1){
        input
    }
    else{
        getFibOutputRecursive(input - 1) + getFibOutputRecursive(input - 2)
    }
}
fun getFibOutputLoop(input: Int): MutableList<Int>{
    val outSeries= mutableListOf<Int>()
    var t1 = 0
    var t2 = 1
    var nextTerm = 1
    when(input){
        0-> outSeries.add(t1)
        1-> {
            outSeries.add(t1)
            outSeries.add(t2)
        }
        2->{
            outSeries.add(t1)
            outSeries.add(t2)
            outSeries.add(nextTerm)
        }
        else -> {
            outSeries.add(t1)
            outSeries.add(t2)
        }
    }
    for(term in 3..input){
        outSeries.add(nextTerm)
        t1 = t2
        t2 = nextTerm
        nextTerm = t1+t2
    }
    return outSeries
}

fun getListData(size: Int): MutableList<String>{
    val list = mutableListOf<String>()
    for(position in 0..size){
        list.add("List item at position $position")
    }
    return list
}