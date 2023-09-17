/**
 * Leetcode problems: https://leetcode.com/problems/next-greater-element-i/description/
 * Date: Mar 10th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun minDepth(root: TreeNode?): Int {
  if (root == null) {
    return 0
  }

  if (root.left == null) {
    return 1 + minDepth(root.right)
  }

  if (root.right == null) {
    return 1 + minDepth(root.left)
  }

  return Math.min(minDepth(root.left), minDepth(root.right)) + 1
}