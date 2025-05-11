/**
 * Leetcode problems: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * Date: Feb 15th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun findNumbers(nums: IntArray): Int {
  var result = 0

  for (i in nums.indices) {
    var inc = 1
    var num = nums[i]
    while (num > 0) {
      num /= 10
      inc = inc xor 1
    }
    result += inc
  }

  return result
}