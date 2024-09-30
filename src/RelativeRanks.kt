/**
 * Leetcode problems: https://leetcode.com/problems/relative-ranks/
 * Date: May 8th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun findRelativeRanks(score: IntArray): Array<String> {
  // find max score
  val length = score.size
  val maxScore = score.max()
  val scoreToIndex = IntArray(maxScore + 1)

  for (i in 0 until length) {
    scoreToIndex[score[i]] = i + 1
  }

  val MEDALS = arrayOf("Gold Medal", "Silver Medal", "Bronze Medal")

  val result = Array(length) { "" }
  var place = 1
  for (i in maxScore downTo 0) {
    if (scoreToIndex[i] != 0) {
      val originalIndex = scoreToIndex[i] - 1
      if (place < 4) {
        result[originalIndex] = MEDALS[place - 1]
      } else {
        result[originalIndex] = place.toString()
      }
      place++
    }
  }

  return result
}