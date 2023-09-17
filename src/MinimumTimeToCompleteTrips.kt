/**
 * Leetcode problems: https://leetcode.com/problems/minimum-time-to-complete-trips/description/
 * Date: Mar 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlog(mk))
 * Space complexity: O(1)
 * Let n be the length of time, m be the upper limit of totalTrips, k is the minimum time taken by one trip
 */
fun minimumTime(time: IntArray, totalTrips: Int): Long {
  var minTime = time[0]
  for (t in time) {
    minTime = Math.min(t, minTime)
  }

  // Left should be equal to min(time) because you need to spend at least that much time to carry out a single trip
  var left = minTime.toLong()
  // Right should be equal to totalTrips * min(time) as
  // in the worst-case scenario where we complete all N trips with a single bus that has the shortest trip time,
  // the time needed would be minTime * totalTrips
  var right = minTime.toLong() * totalTrips

  // Binary search to find the minimum time to finish the task.
  while (left < right) {
    var mid = (left + right) / 2
    if (timeEnough(time, mid, totalTrips)) {
      right = mid
    } else {
      left = mid + 1
    }
  }

  return left
}

// Can these buses finish 'totalTrips' of trips in 'givenTime'?
private fun timeEnough(time: IntArray, givenTime: Long, totalTrips: Int) : Boolean {
  var currentTrips = 0L
  for (t in time) {
    currentTrips += givenTime / t
  }

  return currentTrips >= totalTrips.toLong()
}