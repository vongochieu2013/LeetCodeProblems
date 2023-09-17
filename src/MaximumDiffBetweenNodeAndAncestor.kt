/**
 * Leetcode problems: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 * Date: Mar 10th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

fun maxPathSum(root: TreeNode?): Int {
  val result = IntArray(1)
  result[0] = Int.MIN_VALUE
  dfs(root, result)
  return result[0]
}

private fun dfs(root: TreeNode?, result: IntArray) : Int {
  if (root == null) {
    return 0
  }

  // add the path sum from left subtree. Note that if the path
  // sum is negative, we can ignore it, or count it as 0.
  // This is the reason we use `Math.max` here.
  val left = Math.max(dfs(root.left, result), 0)

  // add the path sum from right subtree. 0 if negative
  var right = Math.max(dfs(root.right, result), 0)

  // if left or right path sum are negative, they are counted
  // as 0, so this statement takes care of all four scenarios
  result[0] = Math.max(result[0], left + right + root.`val`)

  // return the max sum for a path starting at the root of subtree
  return Math.max(left, right) + root.`val`
}