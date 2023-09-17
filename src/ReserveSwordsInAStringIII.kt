/**
 * Leetcode problems: https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun reverseWords(s: String): String {
  val charArray = s.toCharArray()
  var lastSpaceIndex = -1
  for (charIndex in 0..s.length) {
    if (charIndex == s.length || charArray[charIndex] == ' ') {
      var leftIndex = lastSpaceIndex + 1
      var rightIndex = charIndex - 1
      while (leftIndex < rightIndex) {
        var temp = charArray[leftIndex]
        charArray[leftIndex] = charArray[rightIndex]
        charArray[rightIndex] = temp
        leftIndex++
        rightIndex--
      }
      lastSpaceIndex = charIndex
    }
  }

  return String(charArray)
}
