package leetcode

fun canPermutePalindrome(s: String): Boolean {
    var oddCount = 0
    val charCount = IntArray(128) // Assuming ASCII characters

    for (char in s) {
        charCount[char.toInt()]++
        if (charCount[char.toInt()] % 2 == 0) {
            oddCount--
        } else {
            oddCount++
        }
    }

    return oddCount <= 1
}

fun main() {
    val str = "aabba"
    println(canPermutePalindrome(str)) // Output: true
}
