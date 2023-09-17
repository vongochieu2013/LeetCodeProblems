/**
 * Leetcode problems: https://leetcode.com/problems/path-crossing/description/
 * Date: March 5rd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun isPathCrossing(path: String): Boolean {
  var seens = mutableSetOf<String>()
  var x = 0
  var y = 0
  seens.add("0,0")
  for (p in path) {
    when (p) {
      'N'-> y++
      'S' -> y--
      'E' -> x++
      'W' -> x--
    }
    val key = "$x,$y"

    if (seens.contains(key)) {
      return true
    }

    seens.add(key)
  }

  return false
}