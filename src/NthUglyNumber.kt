/**
 * Leetcode problems: https://leetcode.com/problems/ugly-number-ii/description/
 * Date: Aug 18th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun nthUglyNumber(n: Int): Int {
  val uglyNumbers = IntArray(n)
  uglyNumbers[0] = 1

  var indexMultipleOf2 = 0
  var indexMultipleOf3 = 0
  var indexMultipleOf5 = 0
  var nextMultipleOf2 = 2
  var nextMultipleOf3 = 3
  var nextMultipleOf5 = 5

  for (i in 1 until n) {
    val nextUglyNumber = minOf(nextMultipleOf2, nextMultipleOf3, nextMultipleOf5)
    uglyNumbers[i] = nextUglyNumber

    // Update the next multiple of 2, 3, and 5
    if (nextUglyNumber == nextMultipleOf2) {
      indexMultipleOf2++
      nextMultipleOf2 = uglyNumbers[indexMultipleOf2] * 2
    }

    if (nextUglyNumber == nextMultipleOf3) {
      indexMultipleOf3++
      nextMultipleOf3 = uglyNumbers[indexMultipleOf3] * 3
    }

    if (nextUglyNumber == nextMultipleOf5) {
      indexMultipleOf5++
      nextMultipleOf5 = uglyNumbers[indexMultipleOf5] * 5
    }
  }

  return uglyNumbers[n - 1]
}