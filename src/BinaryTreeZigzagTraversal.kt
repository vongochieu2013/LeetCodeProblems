import kotlin.collections.ArrayDeque
/**
 * Leetcode problems: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * Date: Mar 11th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
  val result = mutableListOf<MutableList<Int>>()
  if (root == null) {
    return result
  }
  val queue = ArrayDeque<TreeNode?>()
  var currentLevel = 1
  queue.addLast(root)
  while (queue.isNotEmpty()) {
    val size = queue.size
    val currentList = mutableListOf<Int>()
    for (i in 0 until size) {
      val node = queue.removeFirst()
      currentList.add(node?.`val`!!)

      if (node.left != null) {
        queue.addLast(node.left)
      }
      if (node.right != null) {
        queue.addLast(node.right)
      }
    }

    if (currentLevel % 2 == 0) {
      currentList.reverse()
    }

    result.add(currentList)
    currentLevel++
  }

  return result
}