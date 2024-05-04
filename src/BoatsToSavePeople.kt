import java.util.Arrays

/**
 * Leetcode problems: https://leetcode.com/problems/boats-to-save-people/?envType=daily-question&envId=2024-05-04
 * Date: May 3rd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun numRescueBoats(people: IntArray, limit: Int): Int {
  people.sort()
  var i = 0
  var j = people.size - 1
  var result = 0
  while (i <= j) {
    result++
    if (people[i] + people[j] <= limit) {
      i++
    }

    j--
  }

  return result
}