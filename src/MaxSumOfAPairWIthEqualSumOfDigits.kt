/**
 * Leetcode problems: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
 * Date: March 3rd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun maximumSum(nums: IntArray): Int {
  val digits = mutableMapOf<Int, Int>()
  var result = -1
  for (num in nums) {
    val sumDigit = sumOfDigits(num)
    if (digits.containsKey(sumDigit)) {
      result = Math.max(result, num + digits[sumDigit]!!)
    }
    digits[sumDigit] = Math.max(num, digits.getOrDefault(sumDigit, 0))
  }

  return result
}

private fun sumOfDigits(num: Int) : Int {
  var copyNum = num
  var result = 0
  while (copyNum > 0) {
    result += copyNum % 10
    copyNum /= 10
  }

  return result
}