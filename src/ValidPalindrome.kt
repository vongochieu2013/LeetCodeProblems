/**
 * Leetcode problems: https://leetcode.com/problems/valid-palindrome/description/
 * Date: Mar 18th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun isPalindrome(s: String): Boolean {
  var i = 0
  var j = s.length - 1
  while (i < j) {
    while (i < j && !s[i].isLetterOrDigit()) {
      i++
    }

    while (i < j && !s[j].isLetterOrDigit()) {
      j--
    }

    if (s[i].lowercaseChar() != s[j].lowercaseChar()) {
      return false
    }

    i++
    j--
  }
  return true
}