/**
 * Leetcode problems: https://leetcode.com/problems/add-to-array-form-of-integer/description/
 * Date: Feb 15th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun maxSubarrayLength(nums: IntArray, k: Int): Int {
  val counts = hashMapOf<Int, Int>()
  var result = 0
  var left = 0
  for (right in nums.indices) {
    counts[nums[right]] = counts.getOrDefault(nums[right], 0) + 1
    while (left < nums.size && counts[nums[right]]!! > k) {
      counts[nums[left]] = counts[nums[left]]!! - 1
      left++
    }
    result = Math.max(result, right - left + 1)
  }

  return result
}