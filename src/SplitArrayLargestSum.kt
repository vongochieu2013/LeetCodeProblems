/**
 * Leetcode problems: https://leetcode.com/problems/split-array-largest-sum/
 * Date: Feb 23th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
fun splitArray(nums: IntArray, k: Int): Int {
  var maxNum = 0
  var totalNum = 0
  for (num in nums) {
    maxNum = Math.max(num, maxNum)
    totalNum += num
  }

  var left = maxNum
  var right = totalNum
  var mid = 0
  while (left < right) {
    mid = left + (right - left) / 2
    if (checkNumArray(nums, k, mid)) {
      right = mid
    } else {
      left = mid + 1
    }
  }

  return left
}

private fun checkNumArray(nums: IntArray, k: Int, sum: Int) : Boolean {
  var currentSum = 0
  var currentSplit = 1
  for (num in nums) {
    currentSum += num
    if (currentSum > sum) {
      currentSplit++
      currentSum = num
      if (currentSplit > k) {
        return false
      }
    }
  }

  return currentSplit <= k
}