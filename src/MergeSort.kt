/**
 * Leetcode problems: https://leetcode.com/problems/sort-an-array/editorial/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
fun sortArray(nums: IntArray): IntArray {
  val tempArray = IntArray(nums.size)
  mergeSort(nums, 0, nums.size - 1, tempArray)
  return nums
}

private fun mergeSort(nums: IntArray, left: Int, right: Int, tempArray: IntArray) {
  if (left >= right)
    return

  val mid = (left + right) / 2
  mergeSort(nums, left, mid, tempArray)
  mergeSort(nums, mid + 1, right, tempArray)
  merge(nums, left, mid, right, tempArray)
}

private fun merge(nums: IntArray, left: Int, mid: Int, right: Int, tempArray: IntArray) {
  val start1 = left
  val start2 = mid + 1
  val n1 = mid - left + 1
  val n2 = right - mid

  for (i in 0 until n1) {
    tempArray[start1 + i] = nums[start1 + i]
  }

  for (i in 0 until n2) {
    tempArray[start2 + i] = nums[start2 + i]
  }

  var i = 0
  var j = 0
  var k = left
  while (i < n1 && j < n2) {
    if (tempArray[start1 + i] <= tempArray[start2 + j]) {
      nums[k++] = tempArray[start1 + i++]
    } else {
      nums[k++] = tempArray[start2 + j++]
    }
  }

  while (i < n1) {
    nums[k++] = tempArray[start1 + i++]
  }

  while (j < n2) {
    nums[k++] = tempArray[start2 + j++]
  }
}