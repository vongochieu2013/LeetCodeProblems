
import java.util.Arrays
import kotlin.math.max


/**
 * Leetcode problems: https://leetcode.com/problems/valid-palindrome/description/
 * Date: Mar 18th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun minSwaps(data: IntArray): Int {
  var ones = 0
  for (d in data) {
    ones += d
  }
  var left = 0
  var right = 0
  var currentOne = 0
  var maxOne = 0
  while (right < data.size) {
    currentOne += data[right++]
    if (right - left > ones) {
      currentOne -= data[left]
      left++
    }

    maxOne = Math.max(maxOne, currentOne)
  }

  return ones - maxOne
}