
/**
 * Leetcode problems: https://leetcode.com/problems/largest-number/description/
 * Date: Feb 11th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 * sort algorithm with custom comparator. for example, comparing 3 to 10
 * we compare 310 and 130
 */

fun largestNumber(nums: IntArray): String {
  val asStrings = nums.map { it.toString() }

  val sorted = asStrings.sortedWith { o1, o2 ->
    val first = o1 + o2
    val second = o2 + o1
    second.compareTo(first)
  }
  /*
      val sorted = asStrings.sortedWith(object : Comparator<String> {
      override fun compare(a: String, b: String): Int {
        val order1 = a + b
        val order2 = b + a
        return order2.compareTo(order1)
      }
    })
   */

  return if (sorted[0] == "0") "0" else sorted.joinToString("")
}