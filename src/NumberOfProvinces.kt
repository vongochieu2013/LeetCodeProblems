/**
 * Leetcode problems: https://leetcode.com/problems/number-of-provinces/
 * Date: Mar 13th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
fun findCircleNum(isConnected: Array<IntArray>): Int {
  var answer = 0
  val n = isConnected.size

  val seens = BooleanArray(n)
  for (i in 0 until n) {
    if (!seens[i]) {
      answer++
      dfs(isConnected, seens, i)
    }
  }

  return answer
}

private fun dfs(isConnected: Array<IntArray>, seens: BooleanArray, i: Int) {
  for (j in isConnected.indices) {
    if (isConnected[i][j] == 1 && !seens[j]) {
      seens[j] = true
      dfs(isConnected, seens, j)
    }
  }
}