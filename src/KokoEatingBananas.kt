import kotlin.math.ceil

/**
 * Leetcode problems: https://leetcode.com/problems/koko-eating-bananas/description/
 * Date: Feb 23th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
fun minEatingSpeed(piles: IntArray, h: Int): Int {
  var maxPile = 0
  for (pile in piles) {
    maxPile = Math.max(maxPile, pile)
  }

  var left = 1
  var right = maxPile
  var mid = 0
  while (left < right) {
    mid = left + (right - left) / 2
    if (checkPile(piles, h, mid)) {
      right = mid
    } else {
      left = mid + 1
    }
  }

  return left
}

fun checkPile(piles: IntArray, h: Int, k: Int) : Boolean {
  var currentHour = 0
  for (pile in piles) {
    currentHour += ceil(pile.toDouble() / k).toInt()
    if (currentHour > h) {
      return false
    }
  }

  return currentHour <= h
}