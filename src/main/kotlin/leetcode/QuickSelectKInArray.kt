package leetcode

fun findKthLargest(nums: IntArray, k: Int): Int {
    if (k < 1 || nums.isEmpty()) return -1 // 无效输入

    return quickSelect(nums, 0, nums.size - 1, nums.size - k)
}

/**
 * 在这个实现中，findKthLargest 函数调用 quickSelect 函数来找到第K大的数。quickSelect 函数使用了快速选择算法，
 * 通过划分数组来确定每次递归时应该继续搜索的部分。partition 函数用于将数组分为两部分，使得左边的元素都小于或等于右边的元素。
 * 然后，通过递归调用 quickSelect 来搜索目标数值所在的部分。最后，当找到目标数值时，返回它。
 */
fun quickSelect(nums: IntArray, left: Int, right: Int, k: Int): Int {
    val pivotIndex = partition(nums, left, right)

    return when {
        pivotIndex == k -> nums[pivotIndex]
        pivotIndex < k -> quickSelect(nums, pivotIndex + 1, right, k)
        else -> quickSelect(nums, left, pivotIndex - 1, k)
    }
}

fun partition(nums: IntArray, left: Int, right: Int): Int {
    val pivot = nums[right]
    var i = left

    for (j in left until right) {
        if (nums[j] <= pivot) {
            swap(nums, i, j)
            i++
        }
    }

    swap(nums, i, right)
    return i
}

fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

fun main() {
    val nums = intArrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3)
    val k = 3
    val result = findKthLargest(nums, k)

    println("The $k-th largest element in the array is: $result")
}
