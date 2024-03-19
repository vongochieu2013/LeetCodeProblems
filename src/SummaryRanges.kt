/**
 * Leetcode problems: https://leetcode.com/problems/valid-palindrome/description/
 * Date: Mar 18th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun summaryRanges(nums: IntArray): List<String> {
  val result = mutableListOf<String>()
  var i = 0
  while (i < nums.size) {
    var leftNum = nums[i]

    while (i + 1 < nums.size && nums[i] + 1 == nums[i + 1]) {
      i++
    }

    if (leftNum == nums[i]) {
      result.add("$leftNum")
    } else {
      result.add("$leftNum->${nums[i]}")
    }
    i++
  }
  return result
}