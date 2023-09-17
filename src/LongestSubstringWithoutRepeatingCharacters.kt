/**
 * Leetcode problems: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Date: March 5rd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Instead of using a set to tell if a character exists or not,
 * we could define a mapping of the characters to its index. Then we can skip the characters immediately when we found a repeated character.
 * The reason is that if s[j] have a duplicate in the range [i,j) with index j′,
 * we don't need to increase i little by little. We can skip all the elements in the range [i,j′]
 * and let i to be j′+1 directly.
 */
fun lengthOfLongestSubstring(s: String): Int {
  val seens = mutableMapOf<Char, Int>()
  var result = 0
  var left = 0
  for (right in s.indices) {
    val c = s[right]
    if (seens.containsKey(c)) {
      left = Math.max(seens.get(c)!! + 1, left)
    }

    result = Math.max(result, right - left + 1)
    seens[c] = right
  }

  return result
}