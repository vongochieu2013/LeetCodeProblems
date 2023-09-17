/**
 * Leetcode problems: https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * Date: March 5rd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

fun swapPairs(head: ListNode?): ListNode? {
  var dummyHead = head

  // Dummy node acts as the prevNode for the head node
  // of the list and hence stores pointer to the head node.
  var dummy = ListNode(-1)
  dummy.next = head

  var prevNode = dummy
  while (dummyHead != null && dummyHead.next != null) {
    // Nodes to be swapped
    var firstNode = dummyHead
    var secondNode = dummyHead.next

    // Swapping
    prevNode.next = secondNode
    firstNode.next = secondNode?.next
    secondNode?.next = firstNode

    // Reinitializing the head and prevNode for next swap
    prevNode = firstNode
    dummyHead = firstNode.next
  }

  // Return the new head node.
  return dummy.next
}