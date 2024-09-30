import java.util.LinkedList

/**
 * Leetcode problems: https://leetcode.com/problems/strobogrammatic-number-iii/
 * Date: Jul 27th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun strobogrammaticInRange(low: String, high: String): Int {
  val result = mutableListOf<String>()
  for (i in low.length..high.length) {
    result.addAll(findStrobogrammatic2(i))
  }

  return result.count { it.toLong() >= low.toLong() && it.toLong() <= high.toLong() }
}

private fun findStrobogrammatic2(n: Int): List<String> {
  val queue = LinkedList<String>()
  var currentStringLength = 0

  if (n % 2 == 0) {
    queue.add("")
    currentStringLength = 0
  } else {
    queue.add("0")
    queue.add("1")
    queue.add("8")
    currentStringLength = 1
  }

  while (currentStringLength < n) {
    val size = queue.size
    for (i in 0 until size) {
      val current = queue.poll()
      if (current.length < n - 2) {
        queue.add("0${current}0")
      }
      queue.add("1${current}1")
      queue.add("6${current}9")
      queue.add("8${current}8")
      queue.add("9${current}6")
    }
    currentStringLength += 2
  }

  return queue
}