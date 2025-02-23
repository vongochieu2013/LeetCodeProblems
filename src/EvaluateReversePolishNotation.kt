import java.util.Stack

/**
 * Leetcode problems: https://leetcode.com/problems/evaluate-reverse-polish-notation/?envType=daily-question&envId=2025-02-17
 * Date: Feb 22th , 2025
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun evalRPN(tokens: Array<String>): Int {
  val stack = Stack<String>()

  for (token in tokens) {
    if ("+-*/".contains(token)) {
      val operand2 = stack.pop().toInt()
      val operand1 = stack.pop().toInt()
      stack.push(when (token) {
        "+" -> (operand1 + operand2).toString()
        "-" -> (operand1 - operand2).toString()
        "*" -> (operand1 * operand2).toString()
        "/" -> (operand1 / operand2).toString()
        else -> ""
      })
    } else {
      stack.push(token)
    }
  }

  return stack.pop().toInt()
}