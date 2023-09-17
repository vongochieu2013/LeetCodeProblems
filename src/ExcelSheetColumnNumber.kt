/**
 * Leetcode problems: https://leetcode.com/problems/excel-sheet-column-number
 * Date: Feb 10th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

fun titleToNumber(columnTitle: String): Int {
  var result = 0

  columnTitle.forEach { c ->
    result *= 26;
    result += c - 'A' + 1
  }

  return result
}