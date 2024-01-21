//330
package leetcode

fun minPatches(nums: IntArray, n: Int): Int {
    var currentMax = 0L
    var currentNumIndex = 0
    var res = 0

    while (currentMax < n) {
        if (currentNumIndex < nums.size && nums[currentNumIndex] <= currentMax + 1) {
            // If the next number in nums is within the current range, include it in the range.
            currentMax += nums[currentNumIndex]
            ++currentNumIndex
        } else {
            // If the next number in nums is beyond the current range, add a patch.
            currentMax += currentMax + 1
            ++res
        }
    }

    return res
}

fun main() {
    println(minPatches(intArrayOf(1,5,10), 20));
}