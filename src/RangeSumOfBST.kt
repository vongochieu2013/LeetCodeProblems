/**
 * Leetcode problems: https://leetcode.com/problems/range-sum-of-bst/
 * Date: Mar 11th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
  if (root == null) {
    return 0
  }

  var result = 0
  if (root.`val` in low..high) {
    result += root.`val`
  }

  if (low <= root.`val`) {
    result += rangeSumBST(root.left, low, high)
  }

  if (root.`val` <= high) {
    result += rangeSumBST(root.right, low, high)
  }

  return result
}

fun rangeSumBSTBFS(root: TreeNode?, low: Int, high: Int): Int {
  val queue = ArrayDeque<TreeNode?>()
  queue.addLast(root)
  var result = 0
  while (!queue.isEmpty()) {
    val node = queue.removeFirst()!!
    if (node.`val` in low..high) {
      result += node.`val`
    }

    if (node.left != null && low < node.`val`) {
      queue.addLast(node.left)
    }

    if (node.right != null && node.`val` < high) {
      queue.addLast(node.right)
    }
  }

  return result
}