/**
 * Leetcode problems: https://leetcode.com/problems/count-vowel-strings-in-ranges/
 * Date: Jan 1st, 2025
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
  val result = IntArray(queries.size)
  val vowels = setOf('a', 'e', 'i', 'o', 'u')
  val prefixSum = IntArray(words.size + 1)
  var sum = 0
  for (i in words.indices) {
    val currentWord = words[i]
    if (vowels.contains(currentWord.first()) && vowels.contains(currentWord.last())) {
      sum++
    }
    prefixSum[i] = sum
  }

  for (i in queries.indices) {
    val query = queries[i]
    result[i] = prefixSum[query[1]] - if (query[0] == 0) 0 else prefixSum[query[0] - 1]
  }

  return result
}