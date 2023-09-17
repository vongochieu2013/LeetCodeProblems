/**
 * Leetcode problems: https://leetcode.com/problems/intersection-of-multiple-arrays/description/
 * Date: March 2nd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n * m)
 * Space complexity: O(n)
 */
fun intersection(nums: Array<IntArray>): List<Int> {
  val seens = mutableMapOf<Int, Int>()
  val result = mutableListOf<Int>()
  for (row in nums) {
    for (num in row) {
      seens[num] = seens.getOrDefault(num, 0) + 1
    }
  }

  for (key in seens.keys) {
    if (seens[key] == nums.size) {
      result.add(key)
    }
  }

  return result.sorted()
}