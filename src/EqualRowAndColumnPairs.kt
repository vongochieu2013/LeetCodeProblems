import java.lang.StringBuilder

/**
 * Leetcode problems: https://leetcode.com/problems/equal-row-and-column-pairs/
 * Date: March 3rd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun equalPairs(grid: Array<IntArray>): Int {
  val n = grid.size
  var result = 0
  // Traverse through row
  val rowSeens = mutableMapOf<String, Int>()
  for (row in grid) {
    val key = createKey(row)
    rowSeens[key] = rowSeens.getOrDefault(key, 0) + 1
  }

  val colSeens = mutableMapOf<String, Int>()
  for (j in 0 until n) {
    val currentColumn = IntArray(n)
    for (i in 0 until n) {
      currentColumn[i] = grid[i][j]
    }
    val key = createKey(currentColumn)
    colSeens[key] = colSeens.getOrDefault(key, 0) + 1
  }

  rowSeens.forEach { (key, seen) ->
    result += seen * colSeens.getOrDefault(key, 0)
  }

  return result
}

private fun createKey(arr : IntArray) : String {
  val sb = StringBuilder()
  for (num in arr) {
    sb.append("#${num}")
  }
  return sb.toString()
}