package com.kotlinplayground.classes

object Authenticate {

    @JvmStatic
    fun authenticate(userName : String, password: String){
        println("User authenticated for userName : $userName")
    }
}

fun main() {
    Authenticate.authenticate("Dilip", "abc")
}