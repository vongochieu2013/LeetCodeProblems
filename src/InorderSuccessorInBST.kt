/**
 * Leetcode problems: https://leetcode.com/problems/inorder-successor-in-bst
 * Date: Feb 11th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree.
 * For example [2,1,3] will return 2
 */
fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
  if (root == null || p == null) {
    return null
  }

  var succssor : TreeNode? = null
  var copyRoot = root
  while (copyRoot != null) {
    // If p.val is less than root node val, then the current root is a potential solution
    // Otherwise, the p.val is in the right subtree and we can ignore the whole left subtree
    if (p.`val` < copyRoot.`val`) {
      succssor = copyRoot
      copyRoot = copyRoot.left
    } else {
      copyRoot = copyRoot.right
    }
  }
  return succssor
}