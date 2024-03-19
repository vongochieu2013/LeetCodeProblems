import kotlin.math.log2

/**
 * Leetcode problems: https://leetcode.com/problems/valid-palindrome/description/
 * Date: Mar 18th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun isOneEditDistance(s: String, t: String): Boolean {
  val l1 = s.length
  val l2 = t.length

  if (Math.abs(l1 - l2) > 1) {
    return false
  }

  var i = 0
  var j = 0
  while (i < l1 && j < l2 && s[i] == t[j]) {
    i++
    j++
  }

  if (i == l1 && j == l2) {
    return false
  }

  if (l1 > l2) {
    // Delete only
    return s.substring(i + 1) == t.substring(j)
  } else if (l1 < l2) {
    // Insert only
    return s.substring(i) == t.substring(j + 1)
  } else {
    // Replace
    return s.substring(i + 1) == t.substring(j + 1)
  }
}