/**
 * Leetcode problems: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 * Date: Feb 22th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
fun shipWithinDays(weights: IntArray, days: Int): Int {
  var totalLoad = 0
  var maxLoad = 0
  for (w in weights) {
    totalLoad += w
    maxLoad = Math.max(maxLoad, w)
  }

  var l = maxLoad
  var r = totalLoad
  var mid = 0
  while (l < r) {
    mid = l + (r - l) / 2
    if (checkWeight(weights, mid, days)) {
      r = mid
    } else {
      l = mid + 1
    }
  }

  return l
}

fun checkWeight(weights: IntArray, mid: Int, days: Int) : Boolean {
  var currentLoad = 0
  var daysNeeded = 1
  for (w in weights) {
    currentLoad += w
    if (currentLoad > mid) {
      daysNeeded++
      currentLoad = w
    }
  }

  return daysNeeded <= days
}