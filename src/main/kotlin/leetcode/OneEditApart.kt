package leetcode

fun OneEditApart(s1: String, s2: String): Boolean {
    val lengthDiff = Math.abs(s1.length - s2.length)

    // If the length difference is more than 1, it's impossible to be one edit apart
    if (lengthDiff > 1) return false

    var i = 0
    var j = 0
    var foundDifference = false

    while (i < s1.length && j < s2.length) {
        if (s1[i] != s2[j]) {
            // If a difference is found
            if (foundDifference) return false
            foundDifference = true

            // If the lengths are different, move the pointer of the longer string
            if (lengthDiff == 1) {
                if (s1.length > s2.length) {
                    j--
                } else {
                    i--
                }
            }
        }
        i++
        j++
    }

    return true
}

fun main() {
    // Test cases
    println(OneEditApart("cat", "dog"))    // false
    println(OneEditApart("cat", "cats"))   // true
    println(OneEditApart("cat", "cut"))    // true
    println(OneEditApart("cat", "cast"))   // true
    println(OneEditApart("cat", "at"))     // true
    println(OneEditApart("cat", "act"))    // false
}
