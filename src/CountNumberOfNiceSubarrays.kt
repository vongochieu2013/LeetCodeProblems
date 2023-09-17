/**
 * Leetcode problems: https://leetcode.com/problems/count-number-of-nice-subarrays/description/
 * Date: March 2nd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun numberOfSubarrays(nums: IntArray, k: Int): Int {
  val counts = mutableMapOf<Int, Int>()
  counts[0] = 1
  var current = 0
  var result = 0
  for (num in nums) {
    current += num % 2
    result += counts.getOrDefault(current - k, 0)
    counts[current] = counts.getOrDefault(current, 0) + 1
  }

  return result
}