/**
 * Leetcode problems: https://leetcode.com/problems/cutting-ribbons/
 * Date: Feb 23th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
fun maxLength(ribbons: IntArray, k: Int): Int {
  var maxRib = 0
  for (ribbon in ribbons) {
    maxRib = Math.max(maxRib, ribbon)
  }

  var left = 1
  var right = maxRib
  var mid = 0
  while (left <= right) {
    mid = left + (right - left) / 2
    if (checkRib(ribbons, k, mid)) {
      left = mid + 1
    } else {
      right = mid - 1
    }
  }

  return right.takeIf { right > 0 } ?: 0
}

fun checkRib(ribbons: IntArray, k: Int, length: Int) : Boolean {
  var currentSegment = 0
  for (ribbon in ribbons) {
    currentSegment += ribbon / length
  }

  return currentSegment >= k
}