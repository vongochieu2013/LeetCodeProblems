/**
 * Leetcode problems: https://leetcode.com/problems/palindrome-permutation/description/
 * Date: Oct 23th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solution:
 * If a string with even length is a palindrome, every character in te string must always occur an even number of times.
 * If a string wit odd length is a palindrome, every character except one of the characters always occur an even number of times.
 * In case of a palindrome, the number of characters with odd number of occurrences can't exceed 1(1 in case of odd length and 0 in case of even length).
 */
fun canPermutePalindrome(s: String): Boolean {
  val map = mutableMapOf<Char, Int>()
  for (i in s.indices) {
    map[s[i]] = map.getOrDefault(s[i], 0) + 1
  }

  var oddCharOccur = 0
  map.forEach { (_, count) ->
    oddCharOccur += count % 2
  }

  return oddCharOccur <= 1
}