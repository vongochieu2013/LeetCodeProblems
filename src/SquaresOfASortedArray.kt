/**
 * Leetcode problems: https://leetcode.com/problems/squares-of-a-sorted-array/description/
 * Date: Feb 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun sortedSquares(nums: IntArray): IntArray {
  val result = IntArray(nums.size)
  var left = 0
  var right = nums.size - 1
  var currentIndex = nums.size - 1
  while (currentIndex >= 0) {
    if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
      result[currentIndex] = sqr(nums[right--])
    } else {
      result[currentIndex] = sqr(nums[left++])
    }
    currentIndex--
  }

  return result
}

private fun sqr(num: Int): Int = num * num