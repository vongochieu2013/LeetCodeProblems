/**
 * Leetcode problems: https://leetcode.com/problems/house-robber-iv/?envType=daily-question&envId=2025-03-15
 * Date: Mar 16th, 2025
 * Author: Hieu Vo
 * Time complexity: O(nlogm)
 * Space complexity: O(1)
 */
fun minCapability(nums: IntArray, k: Int): Int {
  fun canStealKHouses(capability: Int): Boolean {
    var count = 0
    var i = 0
    while (i < nums.size) {
      if (nums[i] <= capability) {
        count++
        i += 2
      } else {
        i++
      }
    }
    return count >= k
  }

  var left = nums.minOrNull() ?: 0
  var right = nums.maxOrNull() ?: 0

  while (left < right) {
    val mid = left + (right - left) / 2
    if (canStealKHouses(mid)) {
      right = mid
    } else {
      left = mid + 1
    }
  }

  return left
}