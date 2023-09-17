/**
 * Leetcode problems: https://leetcode.com/problems/island-perimeter/description/
 * Date: Feb 11th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nm)
 * Space complexity: O(1)
 * As you go through each cell on the grid, treat all the land cells as having a perimeter of 4 and add that up to the accumulated result.
    If that land cell has a neighboring land cell, remove 2 sides (one from each land cell) which will be touching between these two cells.
    If your current land cell has a UP land cell, subtract 2 from your accumulated result.
    If your current land cell has a LEFT land cell, subtract 2 from your accumulated result.
 */

fun islandPerimeter(grid: Array<IntArray>): Int {
  val row = grid.size
  val column = grid[0].size
  var p = 0

  for (r in 0 until row) {
    for (c in 0 until column) {
      // check 2 sides, top, left
      if (grid[r][c] == 1) {
        p += 4

        if (r > 0 && grid[r - 1][c] == 1) p-= 2
        if (c > 0 && grid[r][c - 1] == 1) p -= 2
      }
    }
  }

  return p
}