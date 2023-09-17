/**
 * Leetcode problems: https://leetcode.com/problems/running-sum-of-1d-array/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun runningSum(nums: IntArray): IntArray {
  for (i in 1..nums.size - 1) {
    nums[i] += nums[i - 1]
  }

  return nums
}