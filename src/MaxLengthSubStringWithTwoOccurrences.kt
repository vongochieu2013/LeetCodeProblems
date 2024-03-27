/**
 * Leetcode problems: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/
 * Date: Mar 24th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun maximumLengthSubstring(s: String): Int {
  var map = hashMapOf<Char, Int>()
  var maxLength = 0
  var left = 0
  for (right in s.indices) {
    map[s[right]] = map.getOrDefault(s[right], 0) + 1
    while (left < s.length && map[s[right]]!! == 3) {
      map[s[left]] = map[s[left]]!! - 1
      left++
    }
    maxLength = Math.max(maxLength, right - left + 1)
  }

  return maxLength
}