/**
 * Leetcode problems: https://leetcode.com/problems/arranging-coins
 * Date: Feb 10th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 * Simple math. Row count = number of elements in that row. Keep subtracting row count from n until n becomes less than 0.
 * If n < 0, then at some row, we cant accommodate the remaining n. Hence we return 1 less than the current row count
 */

fun arrangeCoins(n: Int): Int {
  var i = 1
  var x = n
  while (x > 0) x -= ++i
  return i - 1
//  var left : Long = 0
//  var right : Long = n.toLong()
//  var k : Long = 0
//  var current: Long
//
//  while (left <= right) {
//    k = left + (right - left) / 2
//    current = (k * (k + 1) / 2)
//
//    if (current == n.toLong()) {
//      return k.toInt()
//    } else {
//      if (current < n) {
//        left = k + 1
//      } else {
//        right = k - 1
//      }
//    }
//  }
//
//  return right.toInt()
}
