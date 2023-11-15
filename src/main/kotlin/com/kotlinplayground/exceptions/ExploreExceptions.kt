package com.kotlinplayground.exceptions

import java.lang.Exception
import java.lang.RuntimeException

fun returnNothing() : Nothing {

    throw RuntimeException("Exception")
}

fun main() {

    println("Name Length is ${nameLength("Dilip")}")
    println("Name Length is ${nameLength(null)}")
    returnNothing()
}

fun nameLength(name: String?): Int? {
    val result =  try {
        name!!.length
    }catch (ex: Exception){
        println("Exception is : $ex")
        null
    }
    return result
}
