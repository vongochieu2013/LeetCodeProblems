/**
 * Leetcode problems: https://leetcode.com/problems/backspace-string-compare/description/
 * Date: Mar 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(m + n) where m,n are the length of S and T
 * Space complexity: O(1)
 * backspaceCompare("y#fo##f", "y#f#o##f")
 */
fun backspaceCompare(s: String, t: String): Boolean {
  var i = s.length - 1
  var j = t.length - 1
  var skipS = 0
  var skipT = 0
  while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
    while (i >= 0) { // Find position of next possible char in build(S)
      if (s[i] == '#') {
        skipS++
        i--
      } else if (skipS > 0) {
        skipS--
        i--
      } else {
        break
      }
    }

    while (j >= 0) { // Find position of next possible char in build(T)
      if (t[j] == '#') {
        skipT++
        j--
      } else if (skipT > 0) {
        skipT--
        j--
      } else {
        break
      }
    }

    // If two actual characters are different
    if (i >= 0 && j >= 0 && s[i] != t[j]) {
      return false
    }

    // If expecting to compare char vs nothing
    if ((i >= 0) != (j >= 0)) {
      return false
    }
    i--
    j--
  }

  return true
}

//  return (checkCompare(s) == checkCompare(t))
//private fun checkCompare(s: String): String {
//  val stack = ArrayDeque<Char>()
//  for (c in s) {
//    if (c == '#') {
//      if (stack.isNotEmpty()) {
//        stack.removeLast()
//      }
//    } else {
//      stack.addLast(c)
//    }
//  }
//
//  return stack.joinToString("")
//}