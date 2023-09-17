/**
 * Leetcode problems: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
 * Date: Mar 21th, 2023
 * Author: Hieu Vo
 * Time complexity: O(mnk)
 * Space complexity: O(mnk)
 */

private val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
  val queue = ArrayDeque<IntArray>()
  queue.addLast(intArrayOf(entrance[0], entrance[1], 0))
  val seens = mutableSetOf<String>()
  seens.add(buildStep(entrance[0], entrance[1]))

  while (!queue.isEmpty()) {
    val (row, col, distance) = queue.removeFirst()
    if ((row != entrance[0] || col != entrance[1]) && (row == 0 || row == maze.size - 1 || col == 0 || col == maze[0].size)) {
       return distance
    }

    for (direction in directions) {
      val newRow = row + direction[0]
      val newCol = col + direction[1]
      if (valid(newRow, newCol, maze) && !seens.contains(buildStep(newRow, newCol))) {
        queue.addLast(intArrayOf(newRow, newCol, distance + 1))
        seens.add(buildStep(newRow, newCol))
      }
    }
  }

  return -1
}

private fun valid(newRow: Int, newCol: Int, maze: Array<CharArray>) : Boolean {
  return 0 <= newRow && newRow < maze.size && 0 <= newCol && newCol < maze[0].size && maze[newRow][newCol] != '+'
}

private fun buildStep(row: Int, col: Int): String = "$row,$col"

