import java.lang.StringBuilder

/**
 * Leetcode problems: https://leetcode.com/problems/remove-vowels-from-a-string
 * Date: Mar 22th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun removeVowels(s: String): String {
  val sb = StringBuilder()
  val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')
  for (i in s) {
    if (!vowels.contains(i)) {
      sb.append(i)
    }
  }

  return sb.toString()
}