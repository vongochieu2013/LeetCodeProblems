/**
 * Leetcode problems: https://leetcode.com/problems/shortest-word-distance/description/
 * Date: Feb 8th, 2023
 * Author: Hieu Vo
 * Time complexity: O(N⋅M) where N is the number of words in the input list, and M is the total length of two input words.
 * Space complexity: O(1)
 */

fun shortestDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
  var current1 = -1
  var current2 = -1
  var shortestDistance = Int.MAX_VALUE
  for (i in 0 until wordsDict.size) {
    if (wordsDict[i] == word1) {
      current1 = i
    } else if (wordsDict[i] == word2) {
      current2 = i
    }

    if (current1 != -1 && current2 != -1) {
      shortestDistance = Math.min(shortestDistance, Math.abs(current2 - current1))
    }
  }
  return shortestDistance.takeIf { shortestDistance != Int.MAX_VALUE } ?: -1
}