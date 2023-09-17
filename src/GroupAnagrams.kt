/**
 * Leetcode problems: https://leetcode.com/problems/group-anagrams/
 * Date: March 2nd, 2023
 * Author: Hieu Vo
 * Time complexity: O(NK), where N is the length of strs, and K is the maximum length of a string in strs.
 * Counting each string is linear in the size of the string, and we count every string.
 * Space complexity: O(NK), the total information content stored in map.
 * We can transform each string s into a character count, counts,
 * consisting of 26 non-negative integers representing the number of a's, b's, c's, etc. We use these counts as the basis for our hash map.
 * For example: aab tranforms to #2#1#0....#0
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {
  val map = mutableMapOf<String, MutableList<String>>()
  val counts = IntArray(26)
  for (str in strs) {
    counts.fill(0)
    for (c in str.toCharArray()) {
      counts[c - 'a']++
    }
    val sb = StringBuilder()
    for (i in counts.indices) {
      sb.append("#${counts[i]}")
    }
    val key = sb.toString()
    if (map[key] == null) {
      map[key] = mutableListOf()
    }
    map[key]?.add(str)

//    val chrArray = str.toCharArray()
//    chrArray.sort()
//    val newString = String(chrArray)
//    if (map[newString] == null) {
//      map[newString] = mutableListOf()
//    }
//    map[newString]?.add(str)
  }

  return map.values.toList()
}