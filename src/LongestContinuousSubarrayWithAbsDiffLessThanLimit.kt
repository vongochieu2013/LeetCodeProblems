import java.util.*
/**
 * Leetcode problems: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
 * Date: Mar 7th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Use two deques - one monotonic increasing and one monotonic decreasing.
 * The monotonic increasing one has the minimum element in the window at the first index.
 * The monotonic decreasing one has the maximum element in the window at the first index.
 * Then, we can use the same sliding window format we learned in the arrays and strings chapter.
 * Add elements to the deques from the right,
 * remove them from the left when the max - min > limit, and make sure to maintain the deques at each iteration.
 */
fun longestSubarray(nums: IntArray, limit: Int): Int {
  val decreasing = LinkedList<Int>()
  val increasing = LinkedList<Int>()
  var left = 0
  var result = 0
  for (right in nums.indices) {
    // maintain the monotonic deque
    while (decreasing.isNotEmpty() && nums[right] > decreasing.last()) {
      decreasing.removeLast()
    }

    while (increasing.isNotEmpty() && nums[right] < increasing.last()) {
      increasing.removeLast()
    }

    decreasing.addLast(nums[right])
    increasing.addLast(nums[right])

    // maintain window property
    while (decreasing.first() - increasing.first() > limit) {
      if (decreasing.first() == nums[left]) {
        decreasing.removeFirst()
      }

      if (increasing.first() == nums[left]) {
        increasing.removeFirst()
      }

      left++
    }
    result = Math.max(result, right - left + 1)
  }

  return result
}
//fun longestSubarray(nums: IntArray, limit: Int): Int {
//  var minValue = Int.MAX_VALUE
//  var maxValue = Int.MIN_VALUE
//  var left = 0
//  var result = 0
//  for (right in nums.indices) {
//    minValue = Math.min(minValue, nums[right])
//    maxValue = Math.max(maxValue, nums[right])
//    if (Math.abs(maxValue - minValue) <= limit) {
//      result = Math.max(right - left + 1, result)
//    } else {
//      left++
//      var (min, max) = findRange(nums, left, right)
//      minValue = min
//      maxValue = max
//    }
//  }
//
//  return result
//}
//
//private fun findRange(nums: IntArray, left: Int, right: Int) : Pair<Int, Int> {
//  var minValue = Integer.MAX_VALUE
//  var maxValue = Integer.MIN_VALUE
//  for (i in left..right) {
//    minValue = Math.min(minValue, nums[i])
//    maxValue = Math.max(maxValue, nums[i])
//  }
//
//  return Pair(minValue, maxValue)
//}