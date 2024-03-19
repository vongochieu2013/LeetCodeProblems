/**
 * Leetcode problems: https://leetcode.com/problems/decode-string/
 * Date: Feb 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O()
 * Space complexity: O()
 */
fun decodeString(s: String): String {
  val stack = ArrayDeque<Char>()
  for (i in s) {
    if (i != ']') {
      stack.addLast(i)
    } else {
      var currentString = StringBuilder()
      while (stack.isNotEmpty() && stack.last() != '[') {
        currentString.append(stack.removeLast())
      }

      // got (
      stack.removeLast()

      // repeat
      var repeatNum = StringBuilder()
      while (stack.isNotEmpty() && stack.last().isDigit()) {
        repeatNum.append(stack.removeLast())
      }

      val repeatString = currentString.reverse().repeat(repeatNum.reverse().toString().toInt())
      for (c in repeatString) {
        stack.addLast(c)
      }
    }
  }
  return stack.joinToString("")
}