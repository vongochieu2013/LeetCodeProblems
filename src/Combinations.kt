/**
 * Leetcode problems: https://leetcode.com/problems/combinations/description/
 * Date: Feb 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(k * Ckn)
 * Space complexity: O(Ckn)
 */
fun combine(n: Int, k: Int): List<List<Int>> {
  val combinations = mutableListOf<List<Int>>()
  generateCombinations(1, n, k, mutableListOf(), combinations)
  return combinations
}

fun generateCombinations(index: Int, n: Int, k: Int, current: MutableList<Int>, combinations: MutableList<List<Int>>) {
  if (current.size == k) {
    combinations.add(ArrayList(current))
    return
  }

  for (i in index until n + 1) {
    current.add(i)
    generateCombinations(i + 1, n, k, current, combinations);
    current.removeAt(current.size - 1)
  }
}
