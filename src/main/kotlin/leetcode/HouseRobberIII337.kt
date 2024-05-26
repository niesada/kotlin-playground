package leetcode

data class RobCost(val rob: Int, val notRob: Int) {
    fun max() = maxOf(rob, notRob)
}

class TreeNode337(var value: Int) {
    var left: TreeNode337? = null
    var right: TreeNode337? = null
}

class Solution {

    fun rob(root: TreeNode337?): Int {
        if (root == null) return 0

        fun heist(node: TreeNode337?): RobCost {
            if (node == null) {
                return RobCost(rob = 0, notRob = 0)
            }

            val left = heist(node.left)
            val right = heist(node.right)

            val rob = node.value + left.notRob + right.notRob
            val notRob = left.max() + right.max()

            return RobCost(rob, notRob)
        }

        return heist(root).max()
    }
}

fun main() {
    // Example 1
    val root1 = TreeNode337(3).apply {
        left = TreeNode337(2).apply {
            right = TreeNode337(4)
        }
        right = TreeNode337(2).apply {
            right = TreeNode337(1)
        }
    }

    // Example 2
//    val root2 = TreeNode337(3).apply {
//        left = TreeNode337(4).apply {
//            left = TreeNode337(1)
//            right = TreeNode337(3)
//        }
//        right = TreeNode337(5).apply {
//            right = TreeNode337(1)
//        }
//    }

    val solution = Solution()
    println("Example 1: ${solution.rob(root1)}") // Output: 7
//    println("Example 2: ${solution.rob(root2)}") // Output: 9
}
