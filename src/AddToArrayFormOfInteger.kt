/**
 * Leetcode problems: https://leetcode.com/problems/add-to-array-form-of-integer/description/
 * Date: Feb 15th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun addToArrayForm(num: IntArray, k: Int): List<Int> {
  val result = mutableListOf<Int>()
  var K = k
  var carry = 0
  var i = num.size - 1
  while (i >= 0 || K > 0) {
    var sum = carry
    if (i >= 0) {
      sum += num[i]
    }
    if (k > 0) {
      sum += K % 10
    }

    result.add(sum % 10)
    carry = sum / 10

    i--
    K /= 10
  }

  if (carry == 1) {
    result.add(1)
  }

  return result.reversed()
}