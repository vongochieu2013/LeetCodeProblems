import java.util.*

/**
 * Leetcode problems: https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
 * Date: Apr 17th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */

fun halveArray(nums: IntArray): Int {
  val maxHeap = PriorityQueue<Double>(Collections.reverseOrder())
  var target = 0.0
  for (num in nums) {
    target += num
    maxHeap.add(num.toDouble())
  }
  target /= 2
  var step = 0
  while (target > 0) {
    val maxNumber: Double = maxHeap.remove()
    target -= (maxNumber / 2)
    maxHeap.add((maxNumber / 2))
    step++
  }

  return step
}