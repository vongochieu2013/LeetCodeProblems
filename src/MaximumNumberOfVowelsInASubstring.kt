/**
 * Leetcode problems: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun maxVowels(s: String, k: Int): Int {
  var result = 0
  var current = 0
  for (i in 0 until s.length) {
    if (checkVowels(s[i])) {
      current++
    }
    if (i >= k && checkVowels(s[i - k])) {
      current--
    }

    result = Math.max(result, current)
    if (result == k) {
      return result
    }
  }

  return result
}

private fun checkVowels(c: Char) : Boolean {
  return c == 'u' || c == 'e' || c == 'o' ||c == 'a' ||c == 'i'
}