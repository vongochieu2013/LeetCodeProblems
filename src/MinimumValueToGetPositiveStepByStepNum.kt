/**
 * Leetcode problems: https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun minStartValue(nums: IntArray): Int {
  var minValue = 0
  var currentTotal = 0
  for (num in nums) {
    currentTotal += num
    minValue = Math.min(minValue, currentTotal)
  }

  return -minValue + 1
}