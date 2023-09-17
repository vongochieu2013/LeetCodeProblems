/**
 * Leetcode problems: https://leetcode.com/problems/find-pivot-index/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun pivotIndex(nums: IntArray): Int {
  var total = 0
  var leftSum = 0
  for (num in nums) {
    total += num
  }

  for (i in nums.indices) {
    if (leftSum == total - nums[i] - leftSum) return i
    leftSum += nums[i]
  }

  return -1
}