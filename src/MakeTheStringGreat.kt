import java.lang.StringBuilder

/**
 * Leetcode problems: https://leetcode.com/problems/make-the-string-great/description/
 * Date: Feb 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun makeGood(s: String): String {
  val stack = ArrayDeque<Char>()
  for (c in s) {
    if (!stack.isEmpty() && checkSameChar(stack.last(),c)) {
      stack.removeLast()
    } else {
      stack.addLast(c)
    }
  }

  val sb = StringBuilder()
  while (stack.isNotEmpty()) {
    sb.append(stack.removeFirst())
  }

  return sb.toString()
}

private fun checkSameChar(a: Char, b: Char): Boolean {
  return a.uppercaseChar() == b || a == b.lowercaseChar()
}