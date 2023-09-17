/**
 * Leetcode problems: https://leetcode.com/problems/is-subsequence/description/
 * Date: Feb 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun isSubsequence(s: String, t: String): Boolean {
  var i = 0
  var j = 0
  while (i < s.length && j < t.length) {
    if (s[i] == t[j]) {
      i++
    }

    j++
  }

  return i == s.length
}