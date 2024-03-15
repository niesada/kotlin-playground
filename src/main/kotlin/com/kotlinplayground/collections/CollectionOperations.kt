package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.KAFKA
import com.kotlinplayground.dataset.courseList

val devPredicate = { c: Course -> c.category == CourseCategory.DEVELOPEMENT }


fun main() {
    val courseList = courseList()

    val devPredicate = { c: Course -> c.category == CourseCategory.DEVELOPEMENT }
    val desPredicate = { c: Course -> c.category == CourseCategory.DESIGN }

//    val list = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
//
//    val mapResult = list.map { outerList ->
//        outerList.map {
//            it.toDouble()
//        }
//    }
//    println("mapResult : $mapResult")
//
//    val flatMapResult = list.flatMap { outerList ->
//        outerList.map {
//            it.toDouble()
//        }
//    }
//    println("flatMapResult : $flatMapResult")

    exploreFilter(courseList, desPredicate)

    exploreMap(courseList, devPredicate)
    val courses = exploreFlatMap(courseList, KAFKA)
    println("courses : $courses")

    exploreHashMap()
    collections_nullablity()
}

fun collections_nullablity() {

    var list : MutableList<String>? = null
    list = mutableListOf()
    list.add("Dilip")
    list.forEach {
        println("Value is : $it")
    }

    val list1 : List<String?> = listOf("Adam", null, "Alex")
    list1.forEach {
        println("Value Length is : ${it?.length}")
    }

}

fun exploreHashMap() {

    val nameAgeMutableMap = mutableMapOf("Dilip" to 33, "Scooby" to 5)
    nameAgeMutableMap
        .forEach { (k,v) ->
            println("Key : $k and the value is $v")
        }

    val value = nameAgeMutableMap.getOrElse("Dilip1") {"abc"}
    println("Value is $value")

    val result = nameAgeMutableMap.containsKey("Dilip")
    println("result is $result")

    val filteredMap = nameAgeMutableMap.filterKeys { it.length > 5}
        .map { it.key.uppercase() }
    println("filteredMap is $filteredMap")

    val maxAge = nameAgeMutableMap
        .maxByOrNull { it.value }

    println("maxAge is $maxAge")


}

fun exploreFlatMap(courseList: MutableList<Course>, kafka: String): List<String> {

    val kafkaCourses = courseList.flatMap { course ->
        val courseName = course.name
        course.topicsCovered.filter {
            it == kafka
        }.map {
            courseName
        }
    }
    return kafkaCourses

}

fun exploreMap(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {

    val courses = courseList
        .filter(predicate)
        .map { "${it.name} - ${it.category}" }
        .forEach {
            println(it)
        }
    println("courses : $courses")

}

fun exploreFilter(
    courseList: MutableList<Course>,
    predicate: (Course) -> Boolean
) {

    courseList
        //.filter { it.category == CourseCategory.DEVELOPEMENT }
        .filter { predicate.invoke(it) }
        .forEach {
            println("Courses : $it")
        }


}
