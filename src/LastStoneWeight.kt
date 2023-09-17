import java.util.*

/**
 * Leetcode problems: https://leetcode.com/problems/last-stone-weight/description/
 * Date: Apr 17th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */

fun lastStoneWeight(stones: IntArray): Int {
  val maxHeap = PriorityQueue<Int>() {a, b -> b - a}
  for (stone in stones) {
    maxHeap.add(stone)
  }

  while (maxHeap.size > 1) {
    val x = maxHeap.remove()
    val y = maxHeap.remove()
    if (x != y) {
      maxHeap.add(x - y)
    }
  }

  return if (maxHeap.size == 0) {
    0
  } else {
    maxHeap.remove()
  }
}

