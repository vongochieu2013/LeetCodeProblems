/**
 * Leetcode problems: https://leetcode.com/problems/sum-of-left-leaves/
 * Date: Mar 20th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
private var result = 0

private fun preOrder(root: TreeNode?) {
  if (root == null) {
    return
  }

  if (root.left != null && root.left?.left == null && root.left?.right == null) {
    result += root.left?.`val`!!
  }

  // Add logic here
  preOrder(root.left)
  preOrder(root.right)
}

fun sumOfLeftLeaves(root: TreeNode?): Int {
  preOrder(root)
  return result
}