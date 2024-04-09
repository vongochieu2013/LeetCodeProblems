/**
 * Leetcode problems: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 * Date: Apr 9th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
  var time = 0
  for (i in 0 until tickets.size) {

    // If the current person is before or at the desired person 'k'
    if (i <= k) {
      time += Math.min(tickets[k], tickets[i])
    } else {
      // If the current person is after 'k', buy the minimum of
      // (tickets available at person 'k' - 1) and the current person
      time += Math.min(tickets[k] - 1, tickets[i])
    }
  }

  return time
}