/**
 * Leetcode problems: https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
 * Date: March 2nd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n + k) where k is the range between min and max value
 * Space complexity: O(k)
 */
fun findWinners(matches: Array<IntArray>): List<List<Int>> {
  // Use an array lossesCount to store the number of losses for each player. Initially, lossesCount[i] = -1 for every index i.
  val lossesCount = IntArray(100001)
  lossesCount.fill(-1)
  for (match in matches) {
    /*
    For each match [winner, loser]:
      If losses_count[loser] = -1, set it to 1, otherwise increment it by 1.
      If losses_count[winner] = -1, set it to 0.
     */
    val winner = match[0]
    val loser = match[1]
    if (lossesCount[winner] == -1) {
      lossesCount[winner] = 0
    }
    if (lossesCount[loser] == -1) {
      lossesCount[loser] = 1
    } else {
      lossesCount[loser]++
    }
  }

  val result = mutableListOf<MutableList<Int>>(mutableListOf(), mutableListOf())
  /*
  Iterate over lossesCount and use two arrays to store these 2 kinds of players, for each index i:
    If lossesCount[i] = 0, add this player to the first array.
    If lossesCount[i] = 1, add this player to the second array.
   */
  for (i in 1..100000) {
    if (lossesCount[i] == 0) {
      result[0].add(i)
    } else if (lossesCount[i] == 1) {
      result[1].add(i)
    }
  }

  return result
}

private fun findWinners1(matches: Array<IntArray>): List<List<Int>> {
  val counts = mutableMapOf<Int, Int>()
  for (match in matches) {
    val winner = match[0]
    val loser = match[1]
    counts[winner] = counts.getOrDefault(winner, 0)
    counts[loser] = counts.getOrDefault(loser, 0) + 1
  }

  val result = mutableListOf<MutableList<Int>>(mutableListOf(), mutableListOf())
  counts.forEach { player, count ->
    if (count == 0) {
      result[0].add(player)
    }

    if (count == 1) {
      result[1].add(player)
    }
  }
  result[0].sort()
  result[1].sort()

  return result
}