/**
 * Leetcode problems: https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun minSubArrayLen(target: Int, nums: IntArray): Int {
  var left = 0
  var currentSum = 0
  var result = nums.size + 1
  for (right in nums.indices) {
    currentSum += nums[right]
    while (currentSum >= target) {
      result = Math.min(result, right - left + 1)
      currentSum -= nums[left++]
    }
  }

  return result.takeIf { it != nums.size + 1 } ?: 0
}