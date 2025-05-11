/**
 * Leetcode problems: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * Date: Feb 15th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
  val rotationsA = check(tops, bottoms, tops[0])
  if (rotationsA != -1 || tops[0] == bottoms[0]) {
    return rotationsA
  }
  return check(tops, bottoms, bottoms[0])

}

private fun check(tops: IntArray, bottoms: IntArray, target: Int): Int {
  // how many rotations should be done
  // to have all elements in A equal to target
  // and to have all elements in B equal to target
  var topRotations = 0
  var bottomRotations = 0

  for (i in tops.indices) {
    // rotations couldn't be done
    if (tops[i] != target && bottoms[i] != target) {
      return -1
    } else if (tops[i] != target) {
      topRotations++
    } else if (bottoms[i] != target) {
      bottomRotations++
    }
  }

  return minOf(topRotations, bottomRotations)
}