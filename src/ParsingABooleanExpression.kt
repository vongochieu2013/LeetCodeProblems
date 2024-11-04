import java.util.Stack

/**
 * Leetcode problems: https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
 * Date: October 27th, 2024
 * Author: Hieu Vo
 * Time complexity:
 * Space complexity:
 */
fun parseBoolExpr(expression: String): Boolean {
  val stack = mutableListOf<Char>()

  for (char in expression) {
    when (char) {
      ',', '(' -> continue
      't', 'f', '!', '&', '|' -> stack.add(char)
      ')' -> processExpression(stack)
    }
  }

  return stack.last() == 't'
}

private fun processExpression(stack: MutableList<Char>) {
  var hasTrue = false
  var hasFalse = false

  // Gather values until we find an operator
  while (stack.last() != '!' && stack.last() != '&' && stack.last() != '|') {
    val topValue = stack.removeAt(stack.lastIndex)
    if (topValue == 't') hasTrue = true
    if (topValue == 'f') hasFalse = true
  }

  // Apply the operator on the gathered values
  val operator = stack.removeAt(stack.lastIndex)
  stack.add(evaluate(operator, hasTrue, hasFalse))
}

private fun evaluate(operator: Char, hasTrue: Boolean, hasFalse: Boolean): Char {
  return when (operator) {
    '!' -> if (hasTrue) 'f' else 't'
    '&' -> if (hasFalse) 'f' else 't'
    '|' -> if (hasTrue) 't' else 'f'
    else -> throw IllegalArgumentException("Invalid operator")
  }
}