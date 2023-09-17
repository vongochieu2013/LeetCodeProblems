import java.util.*

/**
 * Leetcode problems: https://leetcode.com/problems/unique-paths
 * Date: Feb 11th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n * m)
 * Space complexity: O(n * m)
 */

fun uniquePaths(m: Int, n: Int): Int {
  val array = Array(m + 1) { IntArray(n + 1) }

  array.forEach {
    Arrays.fill(it, 1)
  }

  for (i in 1 until m) {
    for (j in 1 until n) {
      array[i][j] = array[i - 1][j] + array[i][j - 1]
    }
  }

  return array[m - 1][n - 1]
}