import java.util.TreeSet

/**
 * Leetcode problems: https://leetcode.com/problems/design-a-number-container-system/description/
 * Date: Apr 7th, 2025
 * Author: Hieu Vo
 * Time complexity: O(logn)
 * Space complexity: O(n)
 */
class NumberContainers() {

  private val indexToNumbers = mutableMapOf<Int, Int>()
  private val numberToIndices = mutableMapOf<Int, TreeSet<Int>>()

  fun change(index: Int, number: Int) {
    if (indexToNumbers.containsKey(index)) {
      val oldNumber = indexToNumbers[index]!!
      numberToIndices[oldNumber]?.remove(index)
      if (numberToIndices[oldNumber]?.isEmpty() == true) {
        numberToIndices.remove(oldNumber)
      }
    }
    indexToNumbers[index] = number
    numberToIndices.computeIfAbsent(number) { TreeSet() }.add(index)
  }

  fun find(number: Int): Int {
    return numberToIndices[number]?.firstOrNull() ?: -1
  }

}