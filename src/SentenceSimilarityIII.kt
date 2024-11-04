/**
 * Leetcode problems: https://leetcode.com/problems/sentence-similarity-iii
 * Date: October 7th, 2024
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
  val words1 = sentence1.split(" ")
  val words2 = sentence2.split(" ")
  if (words1.size > words2.size) {
      return areSentencesSimilar(sentence2, sentence1)
  }

  var start = 0
  while (start < words1.size && words1[start] == words2[start]) {
    start++
  }

  var ends1 = words1.size - 1
  var ends2 = words2.size - 1
  while (ends1 >= 0 && ends2 >= 0 && words1[ends1] == words2[ends2]) {
    ends1--
    ends2--
  }

  // If start is greater than ends1, it means all words in words1 are similar to words2
  return start > ends1
}