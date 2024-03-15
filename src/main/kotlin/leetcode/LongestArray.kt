package leetcode

fun longestIncreasingSequence(matrix: Array<IntArray>): Int {
    var maxCount = 0
    val numRows = matrix.size
    val numCols = matrix[0].size

    for (i in 0 until numRows) {
        for (j in 0 until numCols) {
            val count = checkIncreasingSequence(matrix, i, j, numRows, numCols)
            if (count > maxCount) {
                maxCount = count
            }
        }
    }

    return maxCount
}

fun checkIncreasingSequence(matrix: Array<IntArray>, row: Int, col: Int, numRows: Int, numCols: Int): Int {
    val current = matrix[row][col]
    var count = 1

    // Check right
    var c = col + 1
    while (c < numCols && matrix[row][c] > current) {
        count++
        c++
    }

    // Check down
    var r = row + 1
    while (r < numRows && matrix[r][col] > current) {
        count++
        r++
    }

    return count
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    println("Longest increasing sequence length: ${longestIncreasingSequence(matrix)}")
}
