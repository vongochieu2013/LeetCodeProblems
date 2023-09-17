/**
 * Leetcode problems: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Date: Mar 10th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
  if (root == null) {
    return null
  }

  // The root node is p or q. The answer cannot be below the root node, because then it would be missing the root (which is either p or q) as a descendant.
  if (root == p || root == q) {
    return root
  }

  val left = lowestCommonAncestor(root.left, p, q)
  val right = lowestCommonAncestor(root.right, p, q)

  // One of p or q is in the left subtree, and the other one is in the right subtree.
  // The root must be the answer, because it is the connection point between the two subtrees, and thus the lowest node to have both p and q as descendants.
  if (left != null && right != null) {
    return root
  }


  // Both p and q are in one of the subtrees.
  // In that case, the root is not the answer because we could look inside the subtree and find a "lower" node.
  if (left != null) {
    return left
  }

  return right
}