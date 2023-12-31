/**
 * Leetcode problems: https://leetcode.com/problems/largest-substring-between-two-equal-characters
 * Date: Jan 1st, 2024
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1) because O(26) is still O(1)
 */
fun maxLengthBetweenEqualCharacters(s: String): Int {
  var result = -1
  val map = mutableMapOf<Char, Int>()
  for (i in s.indices) {
    if (map[s[i]] == null) {
      map[s[i]] = i
    } else {
      result = Math.max(result, i - map[s[i]]!! - 1)
    }
  }
  return result
}
