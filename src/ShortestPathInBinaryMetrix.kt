/**
 * Leetcode problems: https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * Date: Mar 16th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

private val directions = arrayOf(intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1), intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1))
fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {

  // Firstly, we need to check that the start and target cells are open.
  if (grid[0][0] == 1 || grid[grid.size - 1][grid.size - 1] == 1) {
    return -1
  }

  // Set up the BFS.
  val queue = ArrayDeque<IntArray>()
  queue.addLast(intArrayOf(0, 0, 1)) // Put distance on the queue
  val visited = Array(grid.size){ BooleanArray(grid.size) } // Used as visited set.
  visited[0][0] = true

  // Carry out the BFS
  while (!queue.isEmpty()) {
    val position = queue.removeFirst()
    val row = position[0]
    val col = position[1]
    val distance = position[2]

    // Check if this is the target cell.
    if (row == grid.size - 1 && col == grid[0].size - 1) {
      return distance
    }
    for (neighbor in getNeighbors(row, col, grid)) {
      val neighborRow = neighbor[0]
      val neighBorCol = neighbor[1]
      if (visited[neighborRow][neighBorCol]) {
        continue
      }
      visited[neighborRow][neighBorCol] = true
      queue.addLast(intArrayOf(neighborRow, neighBorCol, distance + 1))
    }
  }

  // The target was unreachable.
  return -1
}

private fun getNeighbors(row: Int, col: Int, grid: Array<IntArray>) : List<IntArray> {
  val neighbors = mutableListOf<IntArray>()
  for (direction in directions) {
    val newRow = row + direction[0]
    val newCol = col + direction[1]
    if (0 <= newRow && newRow < grid.size && 0 <= newCol && newCol < grid[0].size && grid[newRow][newCol] == 0) {
      neighbors.add(intArrayOf(newRow, newCol))
    }
  }

  return neighbors
}
