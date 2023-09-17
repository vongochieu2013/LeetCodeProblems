/**
 * Leetcode problems: https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 * Date: Mar 14th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n + m)
 * We build adjacent list of all m edges in graph which takes O(m).
 * Each node is only visited once, it takes O(n) to traverse all nodes.
 * Space complexity: O(n + m)
 * We use a hash map to store m edges, which takes O(m)O(m)O(m) space.
  We use a bool array seen to keep track of the visited nodes, which requires O(n)O(n)O(n) space.
  The recusive function takes O(n)O(n)O(n) space.
 * Use one bool array isVisited to mark all visited nodes, set isVisited[source] = true.
  Use a hash map graph to store all edges.
  Start the search from node source. If the current node we are visiting (curr_node) equals destination, return true.
  Otherwise, find all its neighbor nodes that haven't been visited before.
  If there exists such a neighbor node, mark it as visited, move on to this node and repeat step 3.
  If this neighbor node can reach destination, then return true, otherwise, try the next neighbor.
  Return false if we finished the search without finding destination.
 */
fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
  val neighbors = mutableListOf<MutableList<Int>>()
  for (i in 0 until n) {
    neighbors.add(mutableListOf())
  }

  for (edge in edges) {
    neighbors[edge[0]].add(edge[1])
    neighbors[edge[1]].add(edge[0])
  }

  return dfs(neighbors, BooleanArray(n), source, destination)
}

private fun dfs(neighbors: MutableList<MutableList<Int>>, isVisited: BooleanArray, source: Int, destination: Int): Boolean {
  if (source == destination) {
    return true
  }
  if (!isVisited[source]) {
    isVisited[source] = true
    for (neighbor in neighbors[source]) {
      if (dfs(neighbors, isVisited, neighbor, destination)) {
        return true
      }
    }
  }

  return false
}