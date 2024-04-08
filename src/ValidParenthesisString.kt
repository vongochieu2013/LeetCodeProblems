import java.util.Stack

/**
 * Leetcode problems: https://leetcode.com/problems/valid-parenthesis-string
 * Date: Apr 7th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun checkValidString(s: String): Boolean {
  var leftMin = 0
  var leftMax = 0

  for (c in s) {
    if (c == '(') {
      leftMin = leftMin + 1
      leftMax = leftMax + 1
    }  else if (c == ')') {
      leftMin = leftMin - 1
      leftMax = leftMax - 1
    } else {
      leftMin = leftMin - 1
      leftMax = leftMax + 1
    }

    if (leftMax < 0) {
      return false
    }

    if (leftMin < 0) { // For example: s = ( * ) (
      leftMin = 0
    }
  }

  return leftMin == 0
}

/*
(*) -> (*
(*)) -> (*
))

 */