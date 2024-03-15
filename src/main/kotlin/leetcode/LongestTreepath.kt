package leetcode

class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

class Result(var diameter: Int, var height: Int)

fun findLongestPath(root: TreeNode?): Int {
    val result = Result(0, 0)
    findDiameter(root, result)
    return result.diameter
}

fun findDiameter(node: TreeNode?, result: Result): Int {
    if (node == null) return 0

    val leftHeight = findDiameter(node.left, result)
    val rightHeight = findDiameter(node.right, result)

    // 计算当前节点的高度
    val height = 1 + Math.max(leftHeight, rightHeight)

    // 计算当前节点的直径
    val diameterThroughNode = leftHeight + rightHeight

    // 更新全局最长直径
    result.diameter = Math.max(result.diameter, diameterThroughNode)

    return height
}

fun main() {
    // 构建一个树
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    // 找到最长路径
    val longestPath = findLongestPath(root)
    println("The longest path in the tree is: $longestPath")
}
