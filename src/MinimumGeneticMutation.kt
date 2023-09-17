/**
 * Leetcode problems: https://leetcode.com/problems/minimum-genetic-mutation/description/
 * Date: Mar 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O(B)
 * Space complexity: O(n)
 */

fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
  val banks = bank.toMutableSet()
  val queue = ArrayDeque<String>()
  queue.addLast(startGene)
  val isVisited = mutableSetOf<String>()
  isVisited.add(startGene)
  var step = 0
  while (!queue.isEmpty()) {
    val size = queue.size
    for (i in 0 until size) {
      val gene = queue.removeFirst()

      if (gene.equals(endGene)) {
        return step
      }

      for (j in gene.indices) {
        mutableListOf('A', 'C', 'G', 'T').forEach {c ->
          val newGene = "${gene.substring(0, j)}$c${gene.substring(j + 1)}"
          if (!isVisited.contains(newGene) && banks.contains(newGene)) {
            queue.addLast(newGene)
            isVisited.add(newGene)
          }
        }
      }
    }
    step++
  }

  return -1
}