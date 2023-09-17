import java.util.*

/**
 * Leetcode problems: https://leetcode.com/problems/sliding-window-maximum/description/
 * Date: Mar 7th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(k)
 */
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
  val answer = IntArray(nums.size - k + 1)
  val stack = LinkedList<Int>()
  for (i in nums.indices) {

    // maintain monotonic decreasing.
    // all elements in the deque smaller than the current one
    // have no chance of being the maximum, so get rid of them
    while (!stack.isEmpty() && nums[stack.last()] < nums[i]) {
      stack.removeLast()
    }

    stack.addLast(i)

    // queue[0] is the index of the maximum element.
    // if queue[0] + k == i, then it is outside the window
    if (stack.first() + k == i) {
      stack.removeFirst()
    }

    // only add to the answer once our window has reached size k
    if (i >= k - 1) {
      answer[i - k + 1] = nums[stack.first()]
    }
  }

  return answer
}