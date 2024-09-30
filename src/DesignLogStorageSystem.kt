import java.util.TreeMap

/**
 * Leetcode problems: https://leetcode.com/problems/design-log-storage-system/description/
 * Date: Aug 10 th, 2024
 * Author: Hieu Vo
 * Time complexity: O(logn)
 * Space complexity: O(logn + k), where k is the number of logs in the given range
 */
class LogSystem {
  private val storage = TreeMap<String, Int>()

  fun put(id: Int, timestamp: String) {
    storage[timestamp] = id
  }

  fun retrieve(start: String, end: String, granularity: String): List<Int> {
    val adjustedStart = start.adjustTimestamp(granularity, false)
    val adjustedEnd = end.adjustTimestamp(granularity, true)

    return storage.subMap(adjustedStart, true, adjustedEnd, true)
      .values
      .toList()
  }

  // Adjust the timestamp to the start or end of the given granularity
  // For example, if granularity is "Day", the timestamp will be adjusted to the start or end of the day
  // "2017:01:01:23:59:59" -> "2017:01:01:00:00:00" (start of the day)
  // "2017:01:01:23:59:59" -> "2017:01:01:23:59:59" (end of the day)
  private fun String.adjustTimestamp(granularity: String, isEnd: Boolean): String {
    val replacement = when (granularity) {
      "Year" -> if (isEnd) "12:31:23:59:59" else "01:01:00:00:00"
      "Month" -> if (isEnd) "31:23:59:59" else "01:00:00:00"
      "Day" -> if (isEnd) "23:59:59" else "00:00:00"
      "Hour" -> if (isEnd) "59:59" else "00:00"
      "Minute" -> if (isEnd) "59" else "00"
      else -> return this // No replacement needed
    }
    return replaceRange(granularityToIndex(granularity), this.length, replacement)
  }

  // Map the granularity to the index where the replacement should start
  // For example, if granularity is "Day", the replacement should start at index 11
  // "2017:01:01:23:59:59" -> "2017:01:01:00:00:00"
  private fun granularityToIndex(granularity: String): Int {
    return when (granularity) {
      "Year" -> 5
      "Month" -> 8
      "Day" -> 11
      "Hour" -> 14
      "Minute" -> 17
      else -> throw IllegalArgumentException("Invalid granularity: $granularity")
    }
  }
}