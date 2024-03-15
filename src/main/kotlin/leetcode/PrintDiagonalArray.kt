fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12)
    )
    printDiagonal(matrix)
}

fun printDiagonal(matrix: Array<IntArray>) {
    val numRows = matrix.size
    val numCols = matrix[0].size

    for (sum in 0 until numRows + numCols - 1) {
        for (i in 0 until numRows) {
            val j = sum - i
            if (j in 0 until numCols && i < numRows && j < numCols) {
                print("${matrix[i][j]} ")
            }
        }
        println()
    }
}
