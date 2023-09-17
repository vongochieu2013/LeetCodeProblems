/**
 * Leetcode problems: https://leetcode.com/problems/string-compression/description/
 * Date: March 2nd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Declare the variables i – the first index of the current group, and index – the length of the answer (of the compressed string). Initialize i = 0, index = 0.
  While i is less than the length of chars:
    Find the length of the current group of consecutive repeating characters j.
    Add chars[i] to the answer (chars[index++] = chars[i]).
  If j - i > 1, add the string representation of j - i to the answer and increase index accordingly.
  Increase i by j and proceed to the next group.
  Return index.
 */
fun compress(chars: CharArray): Int {
  var i = 0
  var index = 0
  while (i < chars.size) {
    var j = i
    while (j < chars.size && chars[j] == chars[i]) {
      j++
    }
    chars[index++] = chars[i]
    if (j - i > 1) {
      for (letter in (j - i).toString().toCharArray()) {
        chars[index++] = letter
      }
    }
    i = j
  }

  return index
}