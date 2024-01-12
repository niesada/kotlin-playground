package leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun oddEvenList(head: ListNode?): ListNode? {
    val oddNode = ListNode(0)
    val evenNode = ListNode(0)

    var currOdd: ListNode? = oddNode
    var currEven: ListNode? = evenNode

    var currHead: ListNode? = head

    var index = 1
    while (currHead != null) {
        val newNode = ListNode(currHead.`val`)

        if (index % 2 == 1) {
            currOdd?.next = newNode
            currOdd = currOdd?.next
        } else {
            currEven?.next = newNode
            currEven = currEven?.next
        }
        currHead = currHead.next
        index++
    }
    currOdd?.next = evenNode.next

    return oddNode.next
}

fun main() {
    // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    // Calling the oddEvenList function
    val result = oddEvenList(head)

    // Printing the result
    printList(result)
}

// Utility function to print the linked list
fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}