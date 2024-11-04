/**
 * Leetcode problems: https://leetcode.com/problems/string-compression-iii
 * Date: November 2nd, 2024
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

fun compressedString(word: String): String {
  return buildString {
    var currentPosition = 0

    while (currentPosition < word.length) {
      var consecutiveCount = 0
      val currentChar = word[currentPosition]

      while (currentPosition < word.length && word[currentPosition] == currentChar && consecutiveCount < 9) {
        consecutiveCount++
        currentPosition++
      }

      append("$consecutiveCount$currentChar")
    }
  }
}