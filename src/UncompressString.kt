/**
 * Leetcode problems: https://bigfrontend.dev/problem/uncompress-string
 * Date: Nov 20th, 2023
 * Author: Hieu Vo
 * Time complexity: ?
 * Space complexity: O(n^2)
 */
fun uncompress(compressed: String): String {
  val stack = ArrayDeque<Char>()

  for (ch in compressed) {
    if (ch != ')') {
      stack.addLast(ch)
    } else {
      // Build the string inside the current pair of parenthesis
      val sb = StringBuilder()
      while (stack.isNotEmpty() && stack.last() != '(') {
        sb.insert(0, stack.removeLast())
      }
      stack.removeLast() // Remove the '('

      // Build the number for repetition
      val number = StringBuilder()
      while (stack.isNotEmpty() && stack.last().isDigit()) {
        number.insert(0, stack.removeLast())
      }
      val count = number.toString().toInt()

      // Repeat the string and push back to stack
      val repeated = sb.toString().repeat(count)
      repeated.forEach { stack.addLast(it) }
    }
  }

  // Build the final uncompressed string
  return stack.joinToString("")
}





































