/**
 * Leetcode problems: https://leetcode.com/problems/sort-an-array/editorial/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n + k)
 * Here, n is the number of elements in the nums array, and k is the range of value of its elements (minimum value to maximum value).
 * Space complexity: O(n)
 * Create a counting hash map: Create a hash map that maps integers with integers which will be used to store the frequency of each element.
 * Find the minimum and maximum values: Iterate over the array to be sorted to find the minimum and maximum elements which will be used later on.
 * Count the frequency of each element: Loop through the array to be sorted and increase the count of the corresponding element in the counting hash map.
 * Place elements in the original array: Loop through the input array's element's range from the minimum value to the maximum
value and place each element in its proper position in the original array based on the frequency in the hash map.
 */
fun sortArrayCountingSort(nums: IntArray): IntArray {
  countingSort(nums)
  return nums
}

private fun countingSort(nums: IntArray) {
  val counts = mutableMapOf<Int, Int>()
  var minValue = nums[0]
  var maxValue = nums[0]
  for (i in nums.indices) {
    minValue = Math.min(minValue, nums[i])
    maxValue = Math.max(maxValue, nums[i])
    counts[nums[i]] = counts.getOrDefault(nums[i], 0) + 1
  }

  var index = 0
  for (value in minValue..maxValue) {
    while (counts.getOrDefault(value, 0) > 0) {
      nums[index] = value
      index++
      counts[value] = counts[value]!! - 1
    }
  }
}