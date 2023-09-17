/**
 * Leetcode problems: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
 * Date: March 5rd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
  var l = left
  var r = right
  var prev : ListNode? = null
  var curr = head
  var dummy = head
  while (l > 1) {
    prev = curr
    curr = curr?.next
    l--
    r--
  }

  var connect = prev
  var tail = curr

  while (r > 0) {
    var nextNode = curr?.next
    curr?.next = prev
    prev = curr
    curr = nextNode
    r--
  }

  if (connect != null) {
    connect.next = prev
  } else {
    dummy = prev
  }

  tail?.next = curr
  return dummy
}