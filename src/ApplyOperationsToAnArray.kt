/**
 * Leetcode problems: https://leetcode.com/problems/add-to-array-form-of-integer/description/
 * Date: Feb 15th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun applyOperations(nums: IntArray): IntArray {
  val res = IntArray(nums.size) { i -> 0}
  var currPtr = 0
  for ((i, num) in nums.withIndex()) {
    if (num == 0) continue
    if (i == nums.size - 1) {
      res[currPtr] = num
    } else if (num == nums[i + 1]) {
      nums[i + 1] = 0
      res[currPtr] = num * 2
      currPtr++
    } else if (num != 0) {
      res[currPtr] = num
      currPtr++
    }
  }
  return res
}