package leetcode

fun main() {
    val matrix = arrayOf(
        intArrayOf(9, 9, 4),
        intArrayOf(6, 6, 8),
        intArrayOf(2, 1, 1)
    )

    val result = longestIncreasingPath(matrix)
    println("Length of the longest increasing path: $result")
}

fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    val m = matrix.size
    val n = matrix[0].size
    val memo = Array<IntArray>(m) { IntArray(n) { -1 } }
    val recStack = Array<IntArray>(m) { IntArray(n) }

    fun dfs(row: Int, col: Int, prev: Int = -1): Int {
        if (row < 0 || col < 0 || row >= m || col >= n) return 0
        if (recStack[row][col] != 0 || matrix[row][col] <= prev) return 0
        if (memo[row][col] != -1) return memo[row][col]

        recStack[row][col] = 1
        val value = matrix[row][col]

        val up = dfs(row-1,col,value)
        val down = dfs(row+1,col,value)
        val left = dfs(row,col-1,value)
        val right = dfs(row,col+1,value)

        recStack[row][col] = 0

        memo[row][col] = 1 + maxOf(up, down, maxOf(left, right))

        return memo[row][col]
    }

    var max = Int.MIN_VALUE
    for (row in matrix.indices) {
        for (col in matrix[row].indices) {
            max = maxOf(max, dfs(row, col))
        }
    }

    return max
}