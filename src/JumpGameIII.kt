/**
 * Leetcode problems: https://leetcode.com/problems/minimum-genetic-mutation/description/
 * Date: Mar 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

fun canReach(arr: IntArray, start: Int): Boolean {
  val queue = ArrayDeque<Int>()
  queue.addLast(start)
  while (!queue.isEmpty()) {
    val currentStep = queue.removeFirst()

    // check if reach zero
    if (arr[currentStep] == 0) {
      return true
    }

    if (arr[currentStep] < 0) {
      continue
    }

    // check available next steps
    val left = currentStep - arr[currentStep]
    val right = currentStep + arr[currentStep]
    if (left >= 0) {
      queue.addLast(left)
    }

    if (right < arr.size) {
      queue.addLast(right)
    }

    // mark as visited
    arr[currentStep] = -arr[currentStep]
  }

  return false
}