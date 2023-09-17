/**
 * Leetcode problems: https://leetcode.com/problems/solving-questions-with-brainpower/description/
 * Date: May 12th, 2023
 * Author: Hieu Vo
 * Time complexity: O()
 * Space complexity: O()
 */
fun mostPoints(questions: Array<IntArray>): Long {
  val n = questions.size
  val dp = LongArray(n)
  dp[n - 1] = questions[n - 1][0].toLong()

  for (i in n - 2 downTo 0) {
    dp[i] = questions[i][0].toLong()
    val skip = questions[i][1]
    if (i + skip + 1 < n) {
      dp[i] += dp[i + skip + 1]
    }

    // dp[i] = max(solve it, skip it)
    dp[i] = Math.max(dp[i], dp[i + 1])
  }

  return dp[0]
}