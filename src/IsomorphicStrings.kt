/**
 * Leetcode problems: https://leetcode.com/problems/isomorphic-strings
 * Date: Feb 10th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Instead of using 2 hashmaps, we can reduce by using 1 map and 1 hashset
 */

fun isIsomorphic(s: String, t: String): Boolean {
  val map = mutableMapOf<Char, Char>()
  val assignedValues = mutableSetOf<Char>()

  for (i in s.indices) {
    if (map.containsKey(s[i]) && map.get(s[i]) != t[i]) {
      return false
    }

    if (!map.containsKey(s[i]) && assignedValues.contains(t[i])) {
      return false
    }

    map[s[i]] = t[i]
    assignedValues.add(t[i])
  }

  return true
}
