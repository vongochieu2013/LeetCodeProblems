/**
 * Leetcode problems: https://leetcode.com/problems/find-the-winner-of-an-array-game/
 * Date: Nov 8th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun getWinner(arr: IntArray, k: Int): Int {
  var maxElement = arr[0]
  for (i in 1 until arr.size) {
    maxElement = Math.max(maxElement, arr[i])
  }

  var winStreak = 0
  var current = arr[0]

  for (i in 1 until arr.size) {
    val opponent = arr[i]

    if (current > opponent) {
      winStreak++
    } else {
      current = opponent
      winStreak = 1
    }

    if (winStreak == k || current == maxElement) {
      return current
    }
  }

  return -1
}