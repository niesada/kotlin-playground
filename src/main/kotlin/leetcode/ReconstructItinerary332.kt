package leetcode

import java.util.*
import kotlin.collections.HashMap

fun findItinerary(tickets: List<List<String>>): List<String> {
    val res = mutableListOf<String>()
    //to push el in alp order
    val map = HashMap<String, PriorityQueue<String>>()

    //init map
    for (t in tickets) {
        val notused: Boolean = map.getOrPut(t[0]) { PriorityQueue() }.add(t[1])
        println(notused)
    }

    fun dfs(departure: String) {
        while (map.contains(departure) && !map[departure]!!.isEmpty()) {
            dfs(map[departure]!!.poll())
        }
        res.add(0, departure)
    }

    dfs("JFK")

    return res
}

fun main() {
    val tickets = listOf(
        listOf("MUC", "LHR"),
        listOf("JFK", "MUC"),
        listOf("SFO", "SJC"),
        listOf("LHR", "SFO")
    )

    val result = findItinerary(tickets)

    println(result)
}
