/**
 * Leetcode problems: https://leetcode.com/problems/roman-to-integer/description/
 * Date: Feb 11th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

fun romanToInt(s: String): Int {
  val dict = mutableMapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
  var i = 0
  var result = 0
  while (i < s.length) {
    val currentValue = dict[s[i]]!!
    if (i < s.length - 1 && currentValue < dict[s[i + 1]]!!) {
        result += (dict[s[i + 1]]!! - currentValue)
        i += 2
    } else {
      result += currentValue
      i++
    }
  }

  return result
}