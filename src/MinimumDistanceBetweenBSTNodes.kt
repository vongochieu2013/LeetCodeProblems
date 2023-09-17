import com.sun.source.tree.Tree

/**
 * Leetcode problems: https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 * Date: Feb 22th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun minDiffInBST(root: TreeNode?): Int {
  val result = intArrayOf(-1, Int.MAX_VALUE)
  inOrderMinDiffInBST(root, result)
  return result[1]
}

fun inOrderMinDiffInBST(root: TreeNode?, result: IntArray) {
  if (root == null) return

  inOrderMinDiffInBST(root.left, result)
  // Do something
  if (result[0] != -1) {
    result[1] = Math.min(result[1], root.`val` - result[0])
  }
  result[0] = root.`val`
  inOrderMinDiffInBST(root.right, result)
}