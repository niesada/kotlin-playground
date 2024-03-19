package leetcode

import kotlin.math.abs

fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == Int.MIN_VALUE && divisor == -1) {
        // 处理溢出情况
        return Int.MAX_VALUE
    }

    val isNegative = (dividend < 0) xor (divisor < 0)
    var dvd = abs(dividend.toLong())
    val dvs = abs(divisor.toLong())
    var quotient = 0L

    for (i in 31 downTo 0) {
        if ((dvd shr i) >= dvs) {
            quotient = quotient or (1L shl i)
            dvd -= (dvs shl i)
        }
    }

    return if (isNegative) -quotient.toInt() else quotient.toInt()
}

fun main() {
    val dividend = 10
    val divisor = 3
    println("Result of $dividend divided by $divisor is: ${divide(dividend, divisor)}")
}
