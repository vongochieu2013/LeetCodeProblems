/**
 * Leetcode problems: https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
 * Date: March 2nd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Maintain the previous index of each card.
 * Minimize difference between current index and previous (if present) among all pairs
 * Else return -1 if no duplicate
 */
fun minimumCardPickup(cards: IntArray): Int {
  val seens = mutableMapOf<Int, Int>()
  var result = Integer.MAX_VALUE
  for (i in cards.indices) {
    if (seens.containsKey(cards[i])) {
      result = Math.min(result, i - seens[cards[i]]!! + 1)
    }

    seens[cards[i]] = i
  }
  return result.takeIf { result != Integer.MAX_VALUE } ?: -1
}