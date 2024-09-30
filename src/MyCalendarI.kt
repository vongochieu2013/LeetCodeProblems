/**
 * Leetcode problems: https://leetcode.com/problems/my-calendar-i/
 * Date: Feb 15th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class MyCalendar() {
  private val calendar = mutableListOf<Pair<Int, Int>>()
  fun book(start: Int, end: Int): Boolean {
    for (event in calendar) {
      if (event.first < end && start < event.second) {
        return false
      }
    }
    calendar.add(start to end)
    return true
  }
}
