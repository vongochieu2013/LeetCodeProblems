/**
 * Leetcode problems: https://leetcode.com/problems/get-equal-substrings-within-budget/description/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun equalSubstring(s: String, t: String, maxCost: Int): Int {
  var left = 0
  var cost = maxCost
  for (right in 0 until s.length) {
    cost -= Math.abs(t[right] - s[right])
    if (cost < 0) {
      cost += Math.abs(t[left] - s[left])
      left++
    }
  }

  return s.length - left
}