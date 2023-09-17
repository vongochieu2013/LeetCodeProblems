/**
 * Leetcode problems: https://leetcode.com/problems/number-of-islands/
 * Date: Mar 13th, 2023
 * Author: Hieu Vo
 * Time complexity: O(m x n)
 * Space complexity: O(m x n)
 */
fun numIslands(grid: Array<CharArray>): Int {
  var answer = 0
  for (i in grid.indices) {
    for (j in 0 until grid[0].size) {
      if (grid[i][j] == '1') {
        answer++
        dfs(grid, i, j)
      }
    }
  }
  return answer
}

private fun dfs(grid: Array<CharArray>, row: Int, col: Int) {
  val r = grid.size
  val c = grid[0].size

  if (row < 0 || row >= r || col < 0 || col >= c || grid[row][col] == '0') {
    return
  }

  grid[row][col] = '0'
  dfs(grid, row, col + 1)
  dfs(grid, row, col - 1)
  dfs(grid, row - 1, col)
  dfs(grid, row + 1, col)
}