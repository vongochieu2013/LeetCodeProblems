import java.util.*
import kotlin.collections.ArrayList

/**
 * Leetcode problems: https://leetcode.com/problems/permutations/
 * Date: Feb 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(k * Ckn)
 * Space complexity: O(Ckn)
 * backtracking = done exploring a branch, let's go back up and explore more branches.
 */
fun permute(nums: IntArray): List<List<Int>> {
  val result = mutableListOf<List<Int>>()
  val current = nums.toMutableList()
  generatePermutations(0, nums.size, current, result)
  return result
}

fun generatePermutations(index: Int, n: Int, current: MutableList<Int>, permutations: MutableList<List<Int>>) {
  if (index == n) {
    permutations.add(ArrayList(current))
  }

  for (i in index until n) {
    Collections.swap(current, i, index)
    generatePermutations(index + 1, n, current, permutations)
    Collections.swap(current, i, index)
  }
}
