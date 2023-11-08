
import jdk.internal.org.jline.utils.Colors


/**
 * Leetcode problems: https://leetcode.com/problems/number-of-segments-in-a-string/description/
 * Date: Oct 24th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * a string index begins a segment if it is preceded by whitespace (or is the first index) and is not whitespace itself,
 * which can be checked in constant time. Finally, we simply return the number of indices for which the condition is satisfied.
 */
fun countSegments(s: String): Int {
  var segmentCount = 0

  for (i in s.indices) {
    if ((i == 0 || s[i - 1] == ' ') && s[i] != ' ') {
      segmentCount++
    }
  }

  return segmentCount
}