/**
 * Leetcode problems: https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 * Date: Mar 13th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 * We traverse the tree and count edges that are directed from a parent to a child. Direction of those edges need to be changed to arrive at zero node.
 * using the adjacency list, and the sign indicates the direction.
 * If the index is positive - the direction is from a parent to a child and we need to change it (change += (to > 0)).
 * Credited to votrubac
 */
fun minReorder(n: Int, connections: Array<IntArray>): Int {
  val al = mutableListOf<MutableList<Int>>()
  for (i in 0 until n) {
    al.add(mutableListOf())
  }

  for (connection in connections) {
    al[connection[0]].add(connection[1])
    al[connection[1]].add(-connection[0])
  }

  return dfs(al, BooleanArray(n), 0)
}

private fun dfs(al: MutableList<MutableList<Int>>, isVisited: BooleanArray, from: Int): Int {
  var change = 0
  isVisited[from] = true
  for (to in al[from]) {
    if (!isVisited[Math.abs(to)]) {
      change += dfs(al, isVisited, Math.abs(to)) + (1.takeIf{ to > 0 } ?: 0)
    }
  }

  return change
}