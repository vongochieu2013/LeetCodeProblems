import java.util.*


/**
 * Leetcode problems: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * Date: Mar 10th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
//fun goodNodes(root: TreeNode?): Int {
//  return dfs(root, Int.MIN_VALUE)
//}
//
//private fun dfs(root: TreeNode?, maxSoFar: Int) : Int {
//  if (root == null) {
//    return 0
//  }
//
//  val left = dfs(root.left, Math.max(root.`val`, maxSoFar))
//  val right = dfs(root.right, Math.max(root.`val`, maxSoFar))
//
//  var result = left + right
//  if (maxSoFar <= root.`val`) {
//    result += 1
//  }
//
//  return result
//}

private class Pair(node: TreeNode?, maxSoFar: Int) {
  var node: TreeNode?
  var maxSoFar: Int

  init {
    this.node = node
    this.maxSoFar = maxSoFar
  }
}

fun goodNodes(root: TreeNode?): Int {
  var numGoodNodes = 0
  val stack = Stack<Pair>()
  stack.push(Pair(root, Int.MIN_VALUE))
  while (stack.size > 0) {
    val curr = stack.pop()
    if (curr.maxSoFar <= curr.node!!.`val`) {
      numGoodNodes++
    }
    if (curr.node!!.left != null) {
      stack.push(Pair(curr.node!!.left, Math.max(curr.node!!.`val`, curr.maxSoFar)))
    }
    if (curr.node!!.right != null) {
      stack.push(Pair(curr.node!!.right, Math.max(curr.node!!.`val`, curr.maxSoFar)))
    }
  }
  return numGoodNodes
}