/**
 * Leetcode problems: https://leetcode.com/problems/two-sum/
 * Date: Feb 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
  val valueToIndex = mutableMapOf<Int, Int>()
  for (i in nums.indices) {
    val complement = target - nums[i]
    if (valueToIndex.containsKey(complement)) {
      return intArrayOf(i, valueToIndex[complement]!!)
    }

    valueToIndex[nums[i]] = i
  }

  return intArrayOf(-1, -1)
}