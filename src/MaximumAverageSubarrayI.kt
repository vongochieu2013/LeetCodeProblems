/**
 * Leetcode problems: https://leetcode.com/problems/maximum-average-subarray-i/description/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Sliding window technique
 */
fun findMaxAverage(nums: IntArray, k: Int): Double {
  var result = 0.0
  for (i in 0 until k) {
    result += nums[i]
  }
  var current = result
  var left = 0
  for (right in k until nums.size) {
    current += nums[right] - nums[left++]
    result = Math.max(current, result)
  }

  return result / k
}