/**
 * Leetcode problems: https://leetcode.com/problems/count-nice-pairs-in-an-array
 * Date: Nov 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlog10(n))
 * Space complexity: O(n)
 */
fun countNicePairs(nums: IntArray): Int {
  val revNums = IntArray(nums.size)
  val mod = 1e9.toInt() + 7

  for (i in nums.indices) {
    revNums[i] = nums[i] - rev(nums[i])
  }

  val map = mutableMapOf<Int, Int>()
  var result = 0
  for (num in revNums) {
    result = (result + map.getOrDefault(num, 0)) % mod
    map[num] = map.getOrDefault(num, 0) + 1
  }

  return result
}

fun rev(num: Int): Int {
  var tempNum = num
  var reserved = 0
  while (tempNum > 0) {
    reserved = reserved * 10 + tempNum % 10
    tempNum /= 10
  }

  return reserved
}