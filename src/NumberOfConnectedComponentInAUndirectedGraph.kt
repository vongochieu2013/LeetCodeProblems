/**
 * Leetcode problems: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 * Date: Mar 14th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n + m)
 * Space complexity: O(n + m)
 */
fun countComponents(n: Int, edges: Array<IntArray>): Int {
  val neighbors = mutableListOf<MutableList<Int>>()
  for (i in 0 until n) {
    neighbors.add(mutableListOf())
  }

  for (edge in edges) {
    neighbors[edge[0]].add(edge[1])
    neighbors[edge[1]].add(edge[0])
  }

  val isVisited = BooleanArray(n)
  var answer = 0
  for (i in 0 until n) {
    if (!isVisited[i]) {
      isVisited[i] = true
      answer++
      dfs(neighbors, isVisited, i)
    }
  }

  return answer
}

private fun dfs(neighbors: MutableList<MutableList<Int>>, isVisited: BooleanArray, node: Int) {
  for (neighbor in neighbors[node]) {
    if (!isVisited[neighbor]) {
      isVisited[neighbor] = true
      dfs(neighbors, isVisited, neighbor)
    }
  }
}