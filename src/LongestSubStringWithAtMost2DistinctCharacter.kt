/**
 * Leetcode problems: https://leetcode.com/problems/add-to-array-form-of-integer/description/
 * Date: April 2bd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.

counts:
e: 1
b: 1

seens: e, c, b
Example 2:

Input: s = "ccaabbb"
counts:
b: 2

seens: a, b
Output: 5
Explanation: The substring is "aabbb" which its length is 5.
 */
fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
  val counts = hashMapOf<Char, Int>()
  val seens = hashSetOf<Char>()

  var left = 0
  var result = 0

  for (right in s.indices) {
    seens.add(s[right])
    counts[s[right]] = counts.getOrDefault(s[right], 0) + 1
    if (seens.size > 2) { // more than 2 distinct char, need to decrease
      result = Math.max(result, right - left)
      while (left < s.length && seens.size > 2) {
        counts[s[left]] = counts.getOrDefault(s[left], 0) - 1
        if (counts[s[left]]!! <= 0) {
          seens.remove(s[left])
        }
        left++
      }
    } else {
      result = Math.max(result, right - left + 1)
    }
  }

  return result
}