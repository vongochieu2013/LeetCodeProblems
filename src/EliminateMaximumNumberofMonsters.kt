import java.util.Arrays

/**
 * Leetcode problems: https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/
 * Date: Nov 7th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
  val arrival = DoubleArray(dist.size)
  for (i in dist.indices) {
    arrival[i] = dist[i].toDouble() / speed[i]
  }

  Arrays.sort(arrival)
  var result = 0

  for (i in arrival.indices) {
    if (arrival[i] <= i) {
      break
    }

    result++
  }

  return result
}