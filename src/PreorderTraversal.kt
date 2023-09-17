import kotlin.collections.ArrayList

/**
 * Leetcode problems: https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Date: Feb 8th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Morris Algorithm.
 * Initialize an answer array. We also need two pointers, curr and last. Initialize curr as the root node.
    While curr is not NULL, check if it has a left child or not:
      If it has a left child, let last be the rightmost node of curr's left subtree. Add curr to the answer and modify last's right child as curr.
      Otherwise, add curr to the answer and move on to curr's right child.
      During the iteration, if we visit a node whose right child is curr, it implies that we are currently at the last node of this curr node. We reset last's right child to NULL and move on to curr's right child.
      Return answer after the iteration stops.

 */

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}

fun preorderTraversal(root: TreeNode?): List<Int> {
  val result = mutableListOf<Int>()
  var current = root
  var last : TreeNode? = null

  while (current != null) {
    // If there is no left child, go for the right child
    // Otherwise, find the rightmost node in the left subtree
    if (current.left == null) {
      result.add(current.`val`)
      current = current.right;
    } else {
      last = current.left!!
      while (last?.right != null && last.right != current) {
        last = last.right
      }

      // If the last node is not modified, we let
      // 'curr' be its right child. Otherwise, it means we
      // have finished visiting the entire left subtree.
      if (last?.right == null) {
        result.add(current.`val`)
        last?.right = current
        current = current.left
      } else {
        last.right = null;
        current = current.right
      }
    }
  }

  return result
}
