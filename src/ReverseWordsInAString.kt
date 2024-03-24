import java.lang.StringBuilder

/**
 * Leetcode problems: https://leetcode.com/problems/reverse-words-in-a-string
 * Date: Mar 21th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun reverseWords1(s: String): String {
  val words = s.trim().split(" ")
  val result = StringBuilder()
  for (i in words.size - 1 downTo 0) {
    if (words[i].isNotEmpty())
      result.append(words[i]).append(" ");
  }

  return result.toString().trim()
}