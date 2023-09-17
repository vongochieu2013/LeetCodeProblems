import java.util.PriorityQueue

/**
 * Leetcode problems: https://leetcode.com/problems/ipo/editorial/
 * Date: Apr 3th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 * Sort the projects by increasing capital. Keep a pointer ptr to the first unavailable project in the sorted array.
  Maintain a priority queue for the profits of available projects. Initially, the priority queue is empty.
  Do the following kkk times:
    Add to the priority queue the profits of the newly available projects. We move the pointer through the sorted array when new projects become available.
    If the priority queue is empty, terminate the algorithm.
    The maximum value in the priority queue is the profit of the project we will start now. Increase our capital by this value. Delete it so since we can not use it anymore.
 */

fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
  val n = profits.size
  val projects = Array(n) { IntArray(2) }
  var result = w
  for (i in projects.indices) {
    projects[i] = intArrayOf(capital[i], profits[i])
  }

  //     val indices = (0 until profits.size).sortedWith(Comparator<Int>{a, b -> capital[b] - capital[a]}).toMutableList();
  projects.sortBy { it[0] }
  // PriorityQueue is a min heap, but we need a max heap, so we comapre it
  val heap = PriorityQueue<Int>{a, b -> b - a}
  var i = 0
  repeat(k) {
    while (i < n && projects[i][0] <= result) {
      heap.add(projects[i][1])
      i++
    }

    if (heap.isEmpty()) {
      return result
    }

    result += heap.remove()
  }
  return result
}