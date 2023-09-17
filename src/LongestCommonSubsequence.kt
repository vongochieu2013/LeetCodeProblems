import java.util.*

/**
 * Leetcode problems: https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/712/dynamic-programming/4542/
 * Date: April 24th, 2023
 * Author: Hieu Vo
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */
fun longestCommonSubsequence(text1: String, text2: String): Int {
  val length1 = text1.length
  val length2 = text2.length
  val dp = Array(length1 + 1) { IntArray(length2 + 1) }
  for (i in length1 - 1 downTo 0) {
    for (j in length2 - 1 downTo 0) {
      if (text1[i] == text2[j]) {
        dp[i][j] = 1 + dp[i + 1][j + 1]
      } else {
        dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j])
      }
    }
  }

  return dp[0][0]
}
//fun longestCommonSubsequence(text1: String, text2: String): Int {
//  val length1 = text1.length
//  val length2 = text2.length
//  val dp = Array(length1) { IntArray(length2) }
//  for (i in 0 until length1) {
//    Arrays.fill(dp[i], -1)
//  }
//
//  return dpMethod(0, 0, text1, text2, length1, length2, dp)
//}
//
//private fun dpMethod(i: Int, j: Int, text1: String, text2: String, length1: Int, length2: Int, dp: Array<IntArray>) : Int {
//  if (i == length1 || j == length2) {
//    return 0
//  }
//
//  if (dp[i][j] != -1) {
//    return dp[i][j]
//  }
//
//  // two characters match
//  val ans = if (text1[i] == text2[j]) {
//    1 + dpMethod(i + 1, j + 1, text1, text2, length1, length2, dp)
//  } else { // doesn't match
//    Math.max(dpMethod(i + 1, j, text1, text2, length1, length2, dp), dpMethod(i, j + 1, text1, text2, length1, length2, dp))
//  }
//  dp[i][j] = ans
//  return ans
//}