package com.kotlinplayground.basics

import com.kotlinplayground.functions.courseName
import com.kotlinplayground.functions.topLevelFunction

fun main() {
    val name: String = "Eddie"
    println(name)

    var age: Int = 34
    println(age)
    age = 41
    println(age)

    val salary = 30000L
    println(salary)

    val course = "Kotlin Spring"
    println("course : $course and the course length is ${course.length}")

    val multiLine = """
        ABC
        DEF
    """.trimIndent()
    println(multiLine)

    val num = topLevelFunction()
    println("Num is : $num")

    println("courseName : $courseName")
}