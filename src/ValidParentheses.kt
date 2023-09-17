/**
 * Leetcode problems: https://leetcode.com/problems/valid-parentheses/
 * Date: Feb 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun isValid(s: String): Boolean {
  val map = mutableMapOf<Char, Char>()
  map['('] = ')'
  map['['] = ']'
  map['{'] = '}'
  val stack = ArrayDeque<Char>()
  for (c in s) {
    if (map.containsKey(c)) {
      stack.add(c)
    } else {
      if (stack.isEmpty() || map[stack.removeLast()] != c) {
        return false
      }
    }
  }

  return stack.isEmpty()
}