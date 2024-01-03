package leetcode

import java.util.Arrays

fun wiggleSort(nums: IntArray): Unit {
    val array = nums.sorted().toMutableList()

    for (i in 1 until nums.size step 2) {
        nums[i] = array.last()
        array.remove(array.last())
    }

    for (i in 0 until nums.size step 2) {
        nums[i] = array.last()
        array.remove(array.last())
    }
    println(Arrays.toString(nums))
}

fun main() {
    wiggleSort(intArrayOf(1,5,1,1,6,4))
}