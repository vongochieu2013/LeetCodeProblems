/**
 * Leetcode problems: https://leetcode.com/problems/strobogrammatic-number/
 * Date: Jul 27th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun isStrobogrammatic(num: String): Boolean {
  val map = hashMapOf<Int, Int>(1 to 1, 0 to 0, 6 to 9, 8 to 8, 9 to 6)
  val length = num.length
  val mid = length / 2
  for (i in 0..mid) {
    val left = num[i].toString().toInt()
    val right = num[length -1 - i].toString().toInt()
    if (map[left] != right) {
      return false
    }
  }

  return true
}