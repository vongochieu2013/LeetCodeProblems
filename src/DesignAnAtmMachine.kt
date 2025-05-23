/**
 * Leetcode problems: https://leetcode.com/problems/design-an-atm-machine
 * Date: Sep 30th, 2024
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class ATM() {
  private val bankNotes = intArrayOf(0, 0, 0, 0, 0)
  private val bankNotesValue = intArrayOf(20, 50, 100, 200, 500)
  fun deposit(banknotesCount: IntArray) {
    for (i in banknotesCount.indices) {
      bankNotes[i] += banknotesCount[i]
    }
  }

  fun withdraw(amount: Int): IntArray {
    val result = intArrayOf(0, 0, 0, 0, 0)
    var remainingAmount = amount
    for (i in bankNotes.size - 1 downTo 0) {
      if (bankNotes[i] == 0) continue
      val count = minOf(remainingAmount / bankNotesValue[i], bankNotes[i])
      result[i] = count
      remainingAmount -= count * bankNotesValue[i]
    }

    return if (remainingAmount == 0) {
      bankNotes.forEachIndexed { index, _ -> bankNotes[index] -= result[index] }
      result
    } else intArrayOf(-1)
  }
}

fun main() {
  val test = "I am Hieu."
  val result = test.split("")
  println(result)

  val result2 = test.toCharArray().map { it.toString() }
  println(result2)

}