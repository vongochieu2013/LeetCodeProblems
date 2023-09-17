/**
 * Leetcode problems: https://leetcode.com/problems/number-of-ways-to-split-array/description/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Optimized from the classic prefix sum technique, which are:
    We only need the total sum of the array instead of building the whole prefix array since we can calculate the leftSection as we went through the loop
    The rightSection will be just whatever the total - leftSection.
    If the leftSection is bigger than the rightSection, then we add to the result.
    All of the total, leftSection, and rightSection variables need to declare Long to pass through all of the test cases.
 */
fun waysToSplitArray(nums: IntArray): Int {
  var total : Long = 0
  var result = 0
  for (i in nums.indices) {
    total += nums[i]
  }

  var leftSection : Long = 0
  for (i in 0 until nums.size - 1) {
    leftSection += nums[i]
    val rightSection : Long = total - leftSection
    if (leftSection >= rightSection) {
      result++
    }
  }

  return result
}