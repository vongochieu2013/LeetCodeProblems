/**
 * Leetcode problems: https://leetcode.com/problems/decode-string/
 * Date: Feb 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O()
 * Space complexity: O()
 */
fun lengthOfLastWord(s: String): Int {
  return s.trim().split(" ").last().length
}