package leetcode

fun findShortestSubstring(s: String): Int {
    val n = s.length
    if (n == 0) return 0

    val lastOccurrence = mutableMapOf<Char, Int>()
    var minLength = Int.MAX_VALUE

    for (end in s.indices) {
        if(lastOccurrence.containsKey(s[end])){
            lastOccurrence[s[end]] = lastOccurrence[s[end]]!! + 1
        } else {
            lastOccurrence[s[end]] = 1
        }
    }

    var currentLength = 0
    for (end in s.indices) {
        var char = s[end]
        var m = end
        val new = lastOccurrence.toMutableMap()

        while (new[char]!! > 1) {
            currentLength += 1
            m++
            new[char] = new[char]!! - 1
            char = s[m]
        }
        val hasNoDuplicates = new.values.all { it <= 1 }
        if (currentLength != 0 && hasNoDuplicates ){
            minLength = minOf(minLength, currentLength)
        }
        currentLength =0
    }

    return if (minLength == Int.MAX_VALUE) 0 else minLength
}

// Example usage
fun main() {
    val s = "xabbcacpqr"
    println(findShortestSubstring(s))  // Output: 2
}
