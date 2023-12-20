package com.kotlinplayground.basics

fun main() {

    for(i in 1..5){
        println("i in $i")
        if(i==3) break
    }

    label()

//    for(i in 1..5){
//        println("i in return $i")
//        if(i==3) return
//    }

    println("End of the Program!")

    outerFunction()
}

fun label() {

    loop@ for(i in 1..5){
        println("i in label $i")
        //if(i==3) break@loop
        innerloop@ for(j in 1..5){
            println("j in label $j")
            //if(j==2) break@innerloop
            if(j==2) continue@loop

        }
    }

}

fun outerFunction() {
    println("Start of outer function")

    // Inner function
    fun innerFunction() {
        println("Start of inner function")

        listOf(1, 2, 3, 4, 5).forEach myLoop@{
            if (it == 3) {
                return@myLoop // Return from the labeled lambda, not from the innerFunction
            }
            println("Inside inner function: $it")
        }

        println("End of inner function")
    }

    innerFunction()

    println("End of outer function")
}