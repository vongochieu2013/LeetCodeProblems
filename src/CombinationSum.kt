/**
 * Leetcode problems: https://leetcode.com/problems/combination-sum/description/
 * Date: Feb 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(N^(T/M + 1) where N is the number of candidates (T/m + 1 is the maximum of nodes in N-ary tree of T/M height
 * Space complexity: O(T/M) where T is the target value, M is the min value
 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
  candidates.sort()
  val combinations = mutableListOf<List<Int>>()
  generateCombinationSum(0, candidates, target, mutableListOf(), combinations)
  return combinations
}

fun generateCombinationSum(index: Int, candidates: IntArray, target: Int, current: MutableList<Int>, combinations: MutableList<List<Int>>) {
  if (target < 0) {
    return
  } else if (target == 0) {
    combinations.add(ArrayList(current))
  }

  for (i in index until candidates.size) {
    current.add(candidates[i])
    generateCombinationSum(i , candidates, target - candidates[i], current, combinations);
    current.removeAt(current.size - 1)
  }
}
