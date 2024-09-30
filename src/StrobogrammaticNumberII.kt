import java.util.LinkedList

/**
 * Leetcode problems: https://leetcode.com/problems/strobogrammatic-number-ii/description/
 * Date: Jul 27th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun findStrobogrammatic(n: Int): List<String> {
  return findStrobogrammatic(n, n)
}

private fun findStrobogrammatic(n: Int, finalLength: Int): List<String> {
  if (n == 0) return listOf("")
  if (n == 1) return listOf("0", "1", "8")

  val result = mutableListOf<String>()
  val list = findStrobogrammatic(n - 2, finalLength)
  for (s in list) {
    if (n != finalLength) {
      result.add("0${s}0")
    }
    result.add("1${s}1")
    result.add("6${s}9")
    result.add("8${s}8")
    result.add("9${s}6")
  }

  return result
}

fun findStrobogrammatic1(n: Int): List<String> {
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