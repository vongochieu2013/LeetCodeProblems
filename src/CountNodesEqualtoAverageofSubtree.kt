/**
 * Leetcode problems: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 * Date: Mar 20th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
var count = 0

// node sum, node count
private fun postOrder(root: TreeNode?): Pair<Int, Int> {
  if (root == null) {
    return Pair(0, 0)
  }

  val left = postOrder(root.left)
  val right = postOrder(root.right)

  val nodeSum = left.first + right.first + root.`val`
  val nodeCount = left.second + right.second + 1

  if (root.`val` == nodeSum / nodeCount) {
    count++
  }

  return Pair(nodeSum, nodeCount)
}

fun averageOfSubtree(root: TreeNode?): Int {
  postOrder(root)
  return count
}