@file:JvmName("CourseUtils")

package com.kotlinplayground.classes

import com.kotlinplayground.CourseJava

data class Course @JvmOverloads constructor(
    val id: Int,
    val name: String,
    val author: String,
    var courseCategory: CourseCategory = CourseCategory.DEVELOPMENT
){
    @JvmField
    var noOfCourse = 10

    companion object{
        @JvmStatic
        fun printName2(name: String = "default") {
            println("name : $name")
        }
    }
}

enum class CourseCategory {
    DEVELOPMENT,
    BUSINESS,
    DESIGN,
    MARKETING
}

@JvmName("printName1")
@JvmOverloads
fun printName(name: String = "default") {
    println("name : $name")
}

fun main() {

    val course = Course(
        1,
        "Reactive Programming in Modern Java using Project Reactor",
        "Dilip"
    )

    println(course)

    val course1 = Course(
        1,
        "Reactive Programming in Modern Java using Project Reactor",
        "Dilip"
    )

    println("Checking Object Equality : ${course == course1}")

    val course3 = course1.copy(
        id = 3, author = "Dilip1"
    )

    println(course3)

    val marketingCourse = Course(
        2,
        "Facebook Marketing",
        "Dilip",
        CourseCategory.MARKETING
    )

    println(marketingCourse)

    val courseJava = CourseJava(
        2,
        "Facebook Marketing",
        "Dilip"
    )
    println("courseJava: $courseJava")
    courseJava.id = 3
    courseJava.name = "abc"
    println("courseJava: $courseJava")
}