//leetcode:331
package leetcode

fun main() {
    println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"))
}


fun isValidSerialization(preorder: String): Boolean {
    val nodes = preorder.split(",")
    var slots = 1 // Start with one available slot for the root node

    for (node in nodes) {
        // One slot is filled by the current node
        slots--

        // If no slots are available, the serialization is incorrect
        if (slots < 0) return false

        // If the node is not null, one new slot is created for the left child
        if (node != "#") slots += 2
    }

    // If there are no available slots at the end, the serialization is correct
    return slots == 0
}