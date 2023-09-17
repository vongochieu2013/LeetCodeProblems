/**
 * Leetcode problems: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 * Date: Feb 10th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nm)
 * Space complexity: O(1)
 * Sliding window solution
 * Explaination:
 * First sub string will start at index 0 and end at index (m - 1) + 0
 * Second sub string will start at index 1 and end at index (m - 1) + 1
 * ...
 * n substring will start at index k and end at index (m - 1) + k
 * Last substring end at index n - 1 -> n - 1 = (m - 1) + k
 * k = n - m
 *
 */
fun strStr(haystack: String, needle: String): Int {
  if (needle.isEmpty()) {
    return 0
  }

  val h = haystack.length
  val n = needle.length

  if (h < n) {
    return -1
  }

  if (h == n) {
    return 0.takeIf { haystack == needle } ?: -1
  }

  for (i in 0 until h) {
    var hIndex = i;
    var nIndex = 0;
    while (hIndex < h && nIndex < n && haystack[hIndex] == needle[nIndex]) {
      hIndex++
      nIndex++
    }

    if (nIndex == n) {
      return i
    }
  }

  return -1
}

/*
  val n = needle.length
val h = haystack.length

for (windowStart in 0.. h - n) {
  for (i in 0 until n) {
    if (needle[i] != haystack[windowStart + i]) {
      break
    }

    if (i == n - 1) {
      return windowStart
    }
  }
}

return -1
 */