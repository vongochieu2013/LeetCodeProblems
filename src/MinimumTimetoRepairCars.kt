import kotlin.math.sqrt

/**
 * Leetcode problems: https://leetcode.com/problems/house-robber-iv/?envType=daily-question&envId=2025-03-15
 * Date: Mar 16th, 2025
 * Author: Hieu Vo
 * Time complexity: O(nlogm)
 * Space complexity: O(1)
 */
fun repairCars(ranks: IntArray, cars: Int): Long {
  val minRank = ranks.minOrNull() ?: 0
  val maxRank = ranks.maxOrNull() ?: 0

  val frequencies = IntArray(maxRank + 1)
  for (rank in ranks) {
    frequencies[rank]++
  }

  var low = 1L
  var high = 1L * minRank * cars * cars


  while (low <= high) {
    val mid = low + (high - low) / 2

    var carRepairs = 0L
    for (rank in 1 until maxRank) {
      carRepairs += frequencies[rank].toLong() * sqrt((mid.toLong() / rank.toLong()).toDouble()).toLong()
    }

    if (carRepairs >= cars) {
      high = mid
    } else {
      low = mid + 1
    }
  }

  return low
}