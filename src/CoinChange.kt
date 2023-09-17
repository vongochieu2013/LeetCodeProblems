import java.util.*

/**
 * Leetcode problems: https://leetcode.com/problems/coin-change/description/
 * Date: April 24th, 2023
 * Author: Hieu Vo
 * Time complexity: O(amount * coins)
 * Space complexity: O(amount + 1)
 */
fun coinChange(coins: IntArray, amount: Int): Int {
  val dp = IntArray(amount + 1)
  Arrays.fill(dp, amount + 1)
  dp[0] = 0
  for (i in 1..amount) {
    for (j in coins.indices) {
      if (i >= coins[j]) {
        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1)
      }
    }
  }

  return dp[amount].takeUnless { dp[amount] > amount } ?: -1
}