/**
 * Leetcode problems: https://leetcode.com/problems/subarray-product-less-than-k/description/
 * Date: Feb 23th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Sliding window technique
 * For example: [10, 5, 2, 6], k = 100
 * Result will be: (the number of subarrays ending at that index is the length of the window after reaching that index)
 * [10]: left = 0, right = 0
 * [5], [10, 5], left = 0, right = 1
 * [2], [5, 2], left = 1, right = 2
 * [6], [2, 6], [5, 2, 6], left = 1, right = 3
 */
fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
  if (k <= 1) {
    return 0
  }

  var left = 0
  var current = 1
  var result = 0
  for (right in nums.indices) {
    current *= nums[right]
    while (left <= right && current >= k) {
      current /= nums[left++]
    }

    result += right - left + 1
  }

  return result
}