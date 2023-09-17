/**
 * Leetcode problems: https://leetcode.com/problems/max-area-of-island/editorial/
 * Date: Mar 14th, 2023
 * Author: Hieu Vo
 * Time complexity: O(r * c)
 * Space complexity: O(r * c)
 */
fun maxAreaOfIsland(grid: Array<IntArray>): Int {
  var maxArea = 0
  for (i in grid.indices) {
    for (j in grid[0].indices) {
      if (grid[i][j] == 1) {
        maxArea = Math.max(dfs(grid, i, j), maxArea)
      }
    }
  }

  return maxArea
}

private fun dfs(grid: Array<IntArray>, i: Int, j: Int): Int {
  if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == 0) {
    return 0
  }

  grid[i][j] = 0
  return (1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1))
}