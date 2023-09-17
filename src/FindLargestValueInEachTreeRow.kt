import kotlin.collections.ArrayDeque
/**
 * Leetcode problems: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * Date: Mar 11th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

fun largestValues(root: TreeNode?): List<Int> {
  val result = mutableListOf<Int>()
  if (root == null) {
    return result
  }
  val queue = ArrayDeque<TreeNode?>()
  queue.addLast(root)
  while (!queue.isEmpty()) {
    val currentLength = queue.size
    var maxNum = Int.MIN_VALUE
    for (i in 0 until currentLength) {
      val currentNode = queue.removeFirst()
      maxNum = Math.max(maxNum, currentNode?.`val`!!)
      if (currentNode.left != null) {
        queue.addLast(currentNode.left)
      }
      if (currentNode.right != null) {
        queue.addLast(currentNode.right)
      }
    }

    result.add(maxNum)

  }

  return result
}