/**
 * Leetcode problems: https://leetcode.com/problems/max-consecutive-ones-ii/description/
 * Date: Oct 23rd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Sliding window technique
 */
fun findMaxConsecutiveOnes(nums: IntArray): Int {
  var left = 0
  var right = 0
  var numZeroes = 0
  var longestSequence = 0

  while (right < nums.size) {
    if (nums[right] == 0) {
      numZeroes++
    }

    while (numZeroes == 2) {
      if (nums[left] == 0) {
        numZeroes--
      }

      left++
    }

    longestSequence = Math.max(longestSequence, right - left + 1)
    right++
  }

  return longestSequence
}