/**
 * Leetcode problems: https://leetcode.com/problems/divide-chocolate/
 * Date: November 2nd, 2024
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */

fun maximizeSweetness(sweetness: IntArray, k: Int): Int {
  val numberOfPeople = k + 1
  var left = sweetness.min()
  var right = sweetness.sum() / numberOfPeople
  while (left < right) {
    val mid = (left + right + 1) / 2

    if (checkCut(sweetness, mid, numberOfPeople)) {
      left = mid
    } else {
      right = mid - 1
    }
  }

  return right
}

private fun checkCut(sweetness: IntArray, mid: Int, numberOfPeople: Int): Boolean {
  var currentSweetness = 0
  var peopleWithChocolate = 0

  for (s in sweetness) {
    currentSweetness += s
    if (currentSweetness >= mid) {
      peopleWithChocolate++
      currentSweetness = 0
    }
  }
  return peopleWithChocolate >= numberOfPeople
}