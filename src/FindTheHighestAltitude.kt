/**
 * Leetcode problems: https://leetcode.com/problems/find-the-highest-altitude/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun largestAltitude(gain: IntArray): Int {
  var currentAltitude = 0
  var maxAltitude = 0
  for (g in gain) {
    currentAltitude += g
    maxAltitude = Math.max(currentAltitude, maxAltitude)
  }

  return maxAltitude
}