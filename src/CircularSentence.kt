/**
 * Leetcode problems: https://leetcode.com/problems/circular-sentence
 * Date: November 2nd, 2024
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

fun isCircularSentence(sentence: String): Boolean {
  for (i in sentence.indices) {
    if (sentence[i] == ' ' && sentence[i - 1] != sentence[i + 1])
      return false
  }
  return sentence.first() == sentence.last()
}

fun rotateString(s: String, goal: String): Boolean {
  if (s.length != goal.length) return false
  return (s + s).contains(goal)
}

fun main() {
  val test = "leetcode exercises sound delightful"
  println(isCircularSentence(test))

}