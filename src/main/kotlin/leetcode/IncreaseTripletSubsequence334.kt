package leetcode

fun increasingTriplet(nums: IntArray): Boolean {
    var firstSmallest = Int.MAX_VALUE
    var secondSmallest = Int.MAX_VALUE

    nums.forEach { num ->
        if (num <= firstSmallest) firstSmallest = num
        else if (num <= secondSmallest) secondSmallest = num
        else return true
    }

    return false
}

fun main() {
    println(increasingTriplet(intArrayOf(1,5,1,1,6,4)))
}