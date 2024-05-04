/**
 * Leetcode problems: https://app.codesignal.com/challenge/muY5LpDT474LCuf7x
 * Date: Apr 23th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
private fun solution(s: String, k: Int): String {
  return s.replace("-","").reversed().chunked(k).joinToString("-").reversed()
}
