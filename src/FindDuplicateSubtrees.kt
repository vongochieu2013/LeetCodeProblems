/**
 * Leetcode problems: https://leetcode.com/problems/find-duplicate-subtrees/description/
 * Date: Feb 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 * The function works as follows:
  Traverse the left subtree of the node and get its ID (call recursively traverse(node->left)).
  Traverse the right subtree of the node and get its ID (call recursively traverse(node->right)).
  Compose a triplet of the following values: the left subtree ID, the value of the node, and the right subtree ID.
  If the triplet is not in the hash map serialToId, we assign a new ID to this triplet – the smallest unused non-negative integer value (we can use the length of the map for this). Otherwise, get the ID from serialToId.
  If the ID occurs for the second time, it means there was already the same subtree as the current one (the subtree of node). In this case, we add node to the answer.
  Return the ID from the function.
 */
private var counterId = 1
fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
  val serialToId = mutableMapOf<String, Int>()
  val idToCount = mutableMapOf<Int, Int>()
  val result = mutableListOf<TreeNode?>()

  postOrderDuplicateSubtrees(root, serialToId, idToCount, result)

  return result
}

fun postOrderDuplicateSubtrees(root: TreeNode?, serialToId: MutableMap<String, Int>, idToCount: MutableMap<Int, Int>, result: MutableList<TreeNode?>) : Int {
  if (root == null) {
    return 0
  }

  val leftId = postOrderDuplicateSubtrees(root.left, serialToId, idToCount, result)
  val rightId = postOrderDuplicateSubtrees(root.right, serialToId, idToCount, result)
  val currentSerial = leftId.toString() + "," + root.`val` + "," + rightId.toString()
  val serialId = serialToId.getOrDefault(currentSerial, counterId)
  if (serialId == counterId) {
    counterId++
  }
  serialToId[currentSerial] = serialId
  idToCount[serialId] = idToCount.getOrDefault(serialId, 0) + 1
  if (idToCount[serialId] == 2) {
    result.add(root)
  }

  return serialId
}