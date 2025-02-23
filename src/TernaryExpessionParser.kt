import java.util.Stack

/**
 * Leetcode problems: https://leetcode.com/problems/ternary-expression-parser/
 * Date: Feb 22nd, 2025
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun parseTernary(expression: String): String {
  val stack = Stack<Char>()
  var current = expression.length - 1
  while (current >= 0) {
    val char = expression[current]
    if (char in '0'..'9' || char == 'T' || char == 'F') {
      stack.push(char)
    } else if (char == '?') {
      val onTrue = stack.pop()
      val onFalse = stack.pop()
      stack.push(if (expression[current - 1] == 'T') onTrue else onFalse)
      current--
    }
    current--
  }

  return stack.peek().toString()
}