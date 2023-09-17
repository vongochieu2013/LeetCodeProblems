/**
 * Leetcode problems: https://leetcode.com/problems/reachable-nodes-with-restrictions/description/
 * Date: Mar 14th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

private var result = 1
fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {
  val neighbors = mutableListOf<MutableList<Int>>()
  for (i in 0 until n) {
    neighbors.add(mutableListOf())
  }

  for (edge in edges) {
    neighbors[edge[0]].add(edge[1])
    neighbors[edge[1]].add(edge[0])
  }

  val seens = BooleanArray(n)
  for (r in restricted) {
    seens[r] = true
  }

  dfs(0, neighbors, seens)
  return result
}

private fun dfs(node: Int, neighbors: MutableList<MutableList<Int>>, seens: BooleanArray) {
  seens[node] = true
  result++
  for (neighbor in neighbors[node]) {
    if (!seens[neighbor]) {
      dfs(neighbor, neighbors, seens)
    }
  }
}

