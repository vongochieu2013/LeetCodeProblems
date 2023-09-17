/**
 * Leetcode problems: https://leetcode.com/problems/open-the-lock/description/
 * Date: Mar 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n^2 * 10^n + D)
 * Space complexity: O(10^n + D)
 * where A is the number of digits in our alphabet, N is the number of digits in the lock, and D is the size of deadends.
 * We might visit every lock combination, plus we need to instantiate our set dead. When we visit every lock combination, we spend O(N^2)
 * time enumerating through and constructing each node.
 */

private class Locked(node: String, steps: Int) {
  var node: String
  var steps: Int

  init {
    this.node = node
    this.steps = steps
  }
}

fun openLock(deadends: Array<String>, target: String): Int {
  val seens = mutableSetOf<String>()
  val queue = ArrayDeque<Locked>()

  for (deadend in deadends) {
    if (deadend.equals("0000")) {
      return -1
    }

    seens.add(deadend)
  }

  queue.addLast(Locked("0000", 0))
  seens.add("0000")
  while (!queue.isEmpty()) {
    val current = queue.removeFirst()
    val currentNode = current.node
    val currentStep = current.steps
    if (currentNode == target) {
      return currentStep
    }

    for (neighbor in neighbors(currentNode)) {
      if (!seens.contains(neighbor)) {
        seens.add(neighbor)
        queue.addLast(Locked(neighbor, currentStep + 1))
      }
    }

  }

  return -1
}

private fun neighbors(currentNode: String): List<String> {
  val neighbors = mutableListOf<String>()
  for (i in 0 until 4) {
    val currentChar = currentNode[i] - '0'
    for (step in intArrayOf(-1, 1)) {
      val newChar = "${((currentChar + step + 10) % 10)}"
      val neighbor = "${currentNode.substring(0, i)}$newChar${currentNode.substring(i + 1)}"
      neighbors.add(neighbor)
    }
  }
  return neighbors
}
