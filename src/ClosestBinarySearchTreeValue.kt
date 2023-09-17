/**
 * Leetcode problems: https://leetcode.com/problems/closest-binary-search-tree-value/description/
 * Date: Mar 12th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun closestValue(root: TreeNode?, target: Double): Int {
  var copyRoot = root
  var result = copyRoot?.`val`!!
  while (copyRoot != null) {
    if (Math.abs(target - copyRoot.`val`) < Math.abs(target - result)) {
      result = copyRoot.`val`
    }

    copyRoot = if (copyRoot.`val` > target) {
      copyRoot.left
    } else {
      copyRoot.right
    }
  }

  return result
}