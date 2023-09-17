/**
 * Leetcode problems: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
 * Date: March 5rd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

fun pairSum(head: ListNode?): Int {

  var slow : ListNode? = head
  var fast = head
  while (fast != null && fast.next != null) {
    slow = slow?.next
    fast = fast.next!!.next
  }

  slow = reverse(slow)
  fast = head
  var result = 0
  while (slow != null) {
    result = Math.max(result, slow.`val` + fast?.`val`!!)
    slow = slow.next
    fast = fast.next
  }

  return result
}

private fun reverse(node: ListNode?) : ListNode? {
  var curr : ListNode? = node
  var prev : ListNode? = null
  while (curr != null) {
    var nextNode = curr.next
    curr.next = prev
    prev = curr
    curr = nextNode
  }

  return prev
}