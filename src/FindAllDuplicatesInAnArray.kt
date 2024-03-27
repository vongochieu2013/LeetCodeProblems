/**
 * Leetcode problems: https://leetcode.com/problems/sum-of-left-leaves/
 * Date: Mar 20th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun findDuplicates(nums: IntArray): List<Int> {
  val appearance = hashSetOf<Int>()
  val result = mutableListOf<Int>()

  for (num in nums) {
    if (!appearance.contains(num)) {
      appearance.add(num)
    } else {
      result.add(num)
    }
  }

  return result
}