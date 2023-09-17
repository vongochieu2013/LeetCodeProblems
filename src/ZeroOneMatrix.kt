/**
 * Leetcode problems: https://leetcode.com/problems/01-matrix/description/
 * Date: Mar 16th, 2023
 * Author: Hieu Vo
 * Time complexity: O(mnk)
 * Space complexity: O(mnk)
 */

private val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
fun shortestPath(grid: Array<IntArray>, k: Int): Int {
  val queue = ArrayDeque<IntArray>()
  queue.addLast(intArrayOf(0, 0, k, 0))
  val seens = mutableSetOf<IntArray>()
  seens.add(intArrayOf(0, 0, k + 1))
  val result = 0
  var currentK = 0
  while (!queue.isEmpty()) {
    val cur = queue.removeFirst()
    val row = cur[0]
    val col = cur[1]
    val remain = cur[2]
    val step = cur[3]
    for (direction in directions) {
      val newRow = row + direction[0]
      val newCol = col + direction[1]
      if (newRow == grid.size && newCol == grid[0].size) {
        return step
      }

      if (valid(newRow, newCol, grid)) {
        if (grid[newRow][newCol] == 0) {
          if (!seens.contains(intArrayOf(newRow, newCol, remain))) {
            seens.add(intArrayOf(newRow, newCol, remain))
            queue.add(intArrayOf(newRow, newCol, remain, step + 1))
          }
          // otherwise, it is an obstacle and we can only pass if we have remaining removals
        } else if (remain > 0 && !seens.contains(intArrayOf(newRow, newCol, remain - 1))) {
          seens.add(intArrayOf(newRow, newCol, remain - 1))
          queue.add(intArrayOf(newRow, newCol, remain - 1, step + 1))
        }
      }
    }
  }

  return -1
}

private fun valid(newRow: Int, newCol: Int, grid: Array<IntArray>) : Boolean {
  return 0 <= newRow && newRow < grid.size && 0 <= newCol && newCol < grid[0].size
}