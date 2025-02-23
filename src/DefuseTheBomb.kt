/**
 * Leetcode problems: https://leetcode.com/problems/defuse-the-bomb/editorial/
 * Date: Nov 17th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun decrypt(code: IntArray, k: Int): IntArray {
  val result = IntArray(code.size)
  if (k == 0) {
    return result
  }
  var start = 1
  var end = k
  var sum = 0
  if (k < 0) {
    start = code.size - Math.abs(k)
    end = code.size - 1
  }

  for (i in start..end) {
    sum += code[i]
  }

  for (i in code.indices) {
    result[i] = sum
    sum -= code[start % code.size]
    start++
    end++
    sum += code[end % code.size]
  }

  return result
}