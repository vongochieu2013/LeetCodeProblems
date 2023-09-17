/**
 * Leetcode problems: https://leetcode.com/problems/missing-ranges/description/
 * Date: Feb 10th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
  val ranges = mutableListOf<String>()
  var prev = lower - 1
  for (i in 0..nums.size) {
    val current = if (i < nums.size) {
      nums[i]
    } else {
      upper + 1
    }

    if (prev + 1 <= current - 1) {
      ranges.add(buildRange(prev + 1, current - 1))
    }
    prev = current
  }

  return ranges
}

fun buildRange(lower: Int, upper: Int) : String {
  return lower.toString().takeIf { lower == upper } ?: "$lower->$upper"
}
