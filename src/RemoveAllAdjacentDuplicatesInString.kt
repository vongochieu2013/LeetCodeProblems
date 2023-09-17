/**
 * Leetcode problems: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 * Date: Mar 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n - d) where D is a total length for all duplicates.
 */
fun removeDuplicates(s: String): String {
  val sb = StringBuilder()
  for (c in s) {
    if (sb.isNotEmpty() && sb.last() == c) {
      sb.deleteCharAt(sb.length - 1)
    } else {
      sb.append(c)
    }
  }

  return sb.toString()
}