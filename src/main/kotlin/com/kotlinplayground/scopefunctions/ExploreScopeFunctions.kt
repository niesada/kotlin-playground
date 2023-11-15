package com.kotlinplayground.scopefunctions

import com.kotlinplayground.classes.Course
import com.kotlinplayground.classes.CourseCategory


fun main() {

    //exploreApply()
    //exploreAlso()
    //exploreLet()
    //exploreWith()
    exploreRun()
}

fun exploreRun() {

    var numbers : MutableList<Int>? = null
    val result = numbers.run {

        numbers = mutableListOf(1, 2, 3)
        numbers?.sum()
    }
    println("Run Result is : $result")

}

fun exploreWith() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    val result = with(numbers){
        println("Size is ${numbers.size}")
        val list = numbers.plus(6)
        list.sum()
    }

    println("With Result is : $result")

}

fun exploreLet() {

    val numbers = mutableListOf(1, 2, 3, 4, 5)
    val result = numbers.map { it * 2 }.filter { it > 5 }.let {
        println(it)
        it.sum()
    }
    println(result)

    var name: String? = null
    name = "Dilip"
    val result1 = name?.let {
        println(it)
        it.uppercase()
    }
    println(result1)

}

fun exploreApply() {

    val courseCategory = ""

    val course = Course(
        1,
        "Design Thinking",
        "Dilip"
    )
        .apply {
            //courseCategory = CourseCategory.DESIGN
            this.courseCategory = CourseCategory.DESIGN
        }

    println("course : $course")
}

fun exploreAlso() {

    val courseCategory = ""

    val course = Course(
        1,
        "Design Thinking",
        "Dilip"
    )
        .also {
            //courseCategory = CourseCategory.DESIGN
            //it.courseCategory = CourseCategory.DESIGN
            println("Object is ready : $it")
        }

    println("course : $course")
}
