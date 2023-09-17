import java.util.*

/**
 * Leetcode problems: https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
 * Date: April 24th, 2023
 * Author: Hieu Vo
 * Time complexity: O(m*k*2)
 * Space complexity: O(m*k*2)
 */
//fun maxProfit(k: Int, prices: IntArray): Int {
//  val length = prices.size
//  val dp = Array(prices.size) { Array(2) { IntArray(k) } }
//  for (i in 0 until length) {
//    for (j in 0 until 2) {
//      Arrays.fill(dp[i][j], -1)
//    }
//  }
//
//  return dpMethod1(0, 0, k, dp, prices)
//}
//
//private fun dpMethod1(i: Int, holding: Int, remain: Int, dp: Array<Array<IntArray>>, prices: IntArray) : Int {
//  if (i == prices.size || remain == 0) {
//    return 0
//  }
//
//  if (dp[i][holding][remain] != -1) {
//    return dp[i][holding][remain]
//  }
//
//  var ans = dpMethod1(i + 1, holding, remain, dp, prices)
//  if (holding == 1) {
//    ans = Math.max(ans, prices[i] + dpMethod1(i + 1, 0, remain - 1, dp, prices))
//  } else {
//    ans = Math.max(ans, - prices[i] + dpMethod1(i + 1, 1, remain, dp, prices))
//  }
//
//  dp[i][holding][remain] = ans
//  return ans
//}
fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
  val length = piles.size
  val dp = Array(length + 1) { IntArray(k + 1) }
  for (i in length - 1 downTo 0) {
    for (remain in 1..k) {
      var ans = dp[i + 1][remain]
      var current = 0
      for (j in 0 until Math.min(remain, piles[i].size)) {
        current += piles[i][j]
        dp[i][remain] = Math.max(dp[i][remain], current + dp[i + 1][remain - j - 1])
      }
    }
  }

  return dp[0][k]
}