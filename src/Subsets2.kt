/**
 * Leetcode problems: https://leetcode.com/problems/subsets-ii/description/
 * Date: Feb 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(2^n)
 * Space complexity: O(n)
 * First, sort the array in ascending order.
    At each recursive function call:
      Add the currentSubset to the subsets list.
      Iterate over the nums array from index to the array end.
        If the element is considered for the first time in that function call,
        add it to the currentSubset list. Make a function call to subsetsWithDupHelper with index = current element position + 1.
        Otherwise, the element is a duplicate. So we skip it as it will generate duplicate subsets (refer to the figure above).
        While backtracking, remove the last added element from the currentSubset and continue the iteration.
      Return subsets list.
 */
fun subsetsWithDup(nums: IntArray): List<List<Int>> {
  nums.sort()
  val subsets = mutableListOf<List<Int>>()
  generateSubsetsWithDup(0, nums, mutableListOf(), subsets)
  return subsets
}

fun generateSubsetsWithDup(index: Int, nums: IntArray, current: MutableList<Int>, subsets: MutableList<List<Int>>) {
  subsets.add(ArrayList(current))
  for (i in index until nums.size) {
    if (index != i && nums[i] == nums[i - 1]) {
      continue
    }
    current.add(nums[i]);
    generateSubsetsWithDup(i + 1, nums, current, subsets);
    current.removeAt(current.size - 1)
  }
}
