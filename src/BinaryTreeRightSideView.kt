import kotlin.collections.ArrayDeque
/**
 * Leetcode problems: https://leetcode.com/problems/binary-tree-right-side-view/editorial/
 * Date: Mar 11th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun rightSideView(root: TreeNode?): List<Int> {
  val result = mutableListOf<Int>()
  if (root == null) {
    return result
  }
  val queue = ArrayDeque<TreeNode?>()
  queue.addLast(root)
  while (!queue.isEmpty()) {
    val currentLength = queue.size
    result.add(queue.last()?.`val`!!)
    for (i in 0 until currentLength) {
      val currentNode = queue.removeFirst()
      if (currentNode?.left != null) {
        queue.addLast(currentNode.left)
      }

      if (currentNode?.right != null) {
        queue.addLast(currentNode.right)
      }
    }

  }

  return result
}