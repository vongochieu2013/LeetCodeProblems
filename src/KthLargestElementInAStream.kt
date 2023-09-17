import java.util.PriorityQueue
import kotlin.math.min

/**
 * Leetcode problems: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 * Date: Apr 18th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */

class KthLargest(k: Int, nums: IntArray) {
  var k = 0
  val minHeap = PriorityQueue<Int>()

  init {
    this.k = k
    for (num in nums) {
      minHeap.add(num)
    }

    while (minHeap.size > k) {
      minHeap.poll()
    }

  }
  fun add(`val`: Int): Int {
    minHeap.offer(`val`)
    if (minHeap.size > k) {
      minHeap.poll()
    }

    return minHeap.peek()
  }

}
