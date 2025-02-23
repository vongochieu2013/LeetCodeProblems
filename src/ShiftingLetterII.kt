/**
 * Leetcode problems: https://leetcode.com/problems/shifting-letters-ii/
 * Date: jan 4th , 2025
 * Author: Hieu Vo
 * Time complexity: O(n+m)
 * Space complexity: O(n)
 */
fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
  val n = s.length
  val diffArray = IntArray(n)

  for (shift in shifts) {
    val (start, end, diff) = shift
    if (diff == 1) { // If direction is forward (1)
      diffArray[start]++
      if (end < n - 1) { // If end is not the last character
        diffArray[end + 1]--
      }
    } else {
      diffArray[start]--
      if (end < n - 1) { // If end is not the last character
        diffArray[end + 1]++
      }
    }
  }

  val result = StringBuilder()
  var numberOfShifts = 0

  for (i in 0 until n) {
    numberOfShifts = (numberOfShifts + diffArray[i]) % 26
    if (numberOfShifts < 0) {
      numberOfShifts += 26
    }

    val newChar = (s[i] - 'a' + numberOfShifts) % 26 + 'a'.toInt()
    result.append(newChar.toChar())
  }

  return result.toString()
}

private fun main() {
  val s = "dztz"
  val shifts = arrayOf(
    intArrayOf(0, 0, 0),
    intArrayOf(1, 1, 1)
  )

  println(shiftingLetters(s, shifts)) // "catz"
}