/**
 * Leetcode problems: https://leetcode.com/problems/shortest-path-visiting-all-nodes
 * Date: Sep 17th, 2023
 * Author: Hieu Vo
 * Time complexity: O(2^n * n^2)
 * Space complexity: O(2^n * n)
 */

// Top-Down DP
private fun dp(node: Int, mask: Int, graph: Array<IntArray>, cache: Array<IntArray>): Int {
  // Base case: Check if the node has been visited, if yes then return the result
  if (cache[node][mask] != 0) {
    return cache[node][mask]
  }

  // Mask only has a single "1", then we have visited all other nodes.
  if ((mask and (mask - 1) == 0)) {
    return 0
  }

  cache[node][mask] = Int.MAX_VALUE - 1 // Avoid infinite loop in recursion

  for (neighbor in graph[node]) {
    if ((mask and (1 shl neighbor)) != 0) {
      // already visited
      val alreadyVisited = dp(neighbor, mask, graph, cache)

      // visiting for the first time.
      // mask ^ (1 << node) operation is flipping the bit at position node.
      val notVisited = dp(neighbor, mask xor (1 shl node), graph, cache)

      // Choose the best option out of all adjacent states, plus 1, and update the entry in the cache of the
      // for the current state.
      val betterOption = Math.min(alreadyVisited, notVisited)
      cache[node][mask] = Math.min(cache[node][mask], 1 + betterOption)
    }
  }

  return cache[node][mask]
}

fun shortestPathLength(graph: Array<IntArray>): Int {
  val length = graph.size

  // A bitmask represent all nodes being visited. If n = 5, then endingMask = 2^5 - 1 = 11111
  val endingMask = (1 shl length) - 1

  // A data structure that will be used to cache results to prevent duplicate computation.
  val cache = Array(length + 1) { IntArray(endingMask + 1) }

  var result = Integer.MAX_VALUE
  for (node in 0 until length) {
    result = Math.min(result, dp(node, endingMask, graph, cache))
  }
  return result
}

fun shortestPathLengthBFS(graph: Array<IntArray>): Int {
  // Base case: If graph only contains one node, then return 0 as we can start at node 0 and complete the problem
  // without taking any steps
  if (graph.size == 1) {
    return 0
  }

  val length = graph.size

  // A bitmask represent all nodes being visited. If n = 5, then endingMask = 2^5 - 1 = 11111
  val endingMask = (1 shl length) - 1

  // Indicate if we have visited a state to prevent cycles
  val seen = Array(length + 1) { BooleanArray(endingMask) }

  // A data structure that implements an abstract queue for BFS
  var queue = mutableListOf<IntArray>()

  for (i in 0 until length) {
    queue.add(intArrayOf(i, 1 shl i))
    seen[i][1 shl i] = true
  }

  var steps = 0
  while (queue.isNotEmpty()) {
    val nextQueue = mutableListOf<IntArray>()
    queue.forEach {
      val node = it[0]
      val mask = it[1]

      for (neighbor in graph[node]) {
        // For each neighbor, declare a new state (neighbor, nextMask), where nextMask = mask | (1 << neighbor)
        val nextMask = mask or (1 shl neighbor)

        // taking one more step to the neighbor will complete visiting all nodes
        if (nextMask == endingMask) {
          return 1 + steps
        }

        if (!seen[neighbor][nextMask]) {
          seen[neighbor][nextMask] = true
          nextQueue.add(intArrayOf(neighbor, nextMask))
        }
      }

      steps++
      queue = nextQueue
    }
  }

  return -1
}

