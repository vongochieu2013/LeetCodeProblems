/**
 * Leetcode problems: https://leetcode.com/problems/subsets/description/
 * Date: Feb 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(2^n)
 * Space complexity: O(n)
 */
fun subsets(nums: IntArray): List<List<Int>> {
  val subsets = mutableListOf<List<Int>>()
  generateSubsets(0, nums, mutableListOf(), subsets)
  return subsets
}

fun generateSubsets(index: Int, nums: IntArray, current: MutableList<Int>, subsets: MutableList<List<Int>>) {
  subsets.add(ArrayList(current))
  for (i in index until nums.size) {
    current.add(nums[i]);
    generateSubsets(i + 1, nums, current, subsets);
    current.removeAt(current.size - 1)
  }
}
