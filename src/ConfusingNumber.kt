/**
 * Leetcode problems: https://leetcode.com/problems/strobogrammatic-number-ii/description/
 * Date: Jul 27th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun confusingNumber(n: Int): Boolean {
  val map = hashMapOf<Int, Int>(1 to 1, 0 to 0, 6 to 9, 8 to 8, 9 to 6)
  var reverse = 0
  var num = n
  while (num > 0) {
    val digit = n % 10
    if (!map.containsKey(digit)) {
      return false
    }

    reverse = reverse * 10 + map[digit]!!
    num /= 10
  }

  return reverse != num
}