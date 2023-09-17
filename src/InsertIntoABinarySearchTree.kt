/**
 * Leetcode problems: https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 * Date: Mar 12th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
  val valNode = TreeNode(`val`)
  if (root == null) {
    return valNode
  }
  var prev: TreeNode = root
  var dummy = root
  while (dummy != null) {
    prev = dummy
    dummy = if (dummy.`val` < `val`) dummy.right else dummy.left
  }

  if (prev.`val` < `val`) {
    prev.right = valNode
  } else {
    prev.left = valNode
  }

  return root
}