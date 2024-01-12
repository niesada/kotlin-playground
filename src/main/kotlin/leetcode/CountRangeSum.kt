package leetcode

class Solution {
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        val n = nums.size
        val prefixSum = LongArray(n + 1)
        for (i in 0 until n) {
            prefixSum[i + 1] = prefixSum[i] + nums[i].toLong()
        }
        return countAndMergeSort(prefixSum, 0, n + 1, lower.toLong(), upper.toLong())
    }

    private fun countAndMergeSort(prefixSum: LongArray, start: Int, end: Int, lower: Long, upper: Long): Int {
        if (end - start <= 1) {
            return 0
        }

        val mid = (start + end) / 2
        var count = countAndMergeSort(prefixSum, start, mid, lower, upper) +
                countAndMergeSort(prefixSum, mid, end, lower, upper)

        var j = mid
        var k = mid
        var t = mid
        val merged = LongArray(end - start)

        for (i in start until mid) {
            while (j < end && prefixSum[j] - prefixSum[i] < lower) {
                j++
            }
            while (k < end && prefixSum[k] - prefixSum[i] <= upper) {
                k++
            }
            while (t < end && prefixSum[t] < prefixSum[i]) {
                merged[t - start] = prefixSum[t]
                t++
            }
            merged[i - start + k - mid] = prefixSum[i]
            count += k - j
        }

        System.arraycopy(merged, 0, prefixSum, start, t - start)
        return count
    }
}

fun main() {
    val solution = Solution()
    val nums = intArrayOf(-2, 5, -1)
    val lower = -2
    val upper = 2
    val result = solution.countRangeSum(nums, lower, upper)
    println(result) // Output: 3
}
