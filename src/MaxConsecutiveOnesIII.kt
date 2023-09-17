/**
 * Leetcode problems: https://leetcode.com/problems/max-consecutive-ones-iii/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Sliding window technique
 */
fun longestOnes(nums: IntArray, k: Int): Int {
  // Main logic
  var left = 0
  var right = 0
  var currentFlip = k
  for (right in nums.indices) {
    // If we include the zero in the window we reduce the value of k
    // Since k is the maximum zeros allowed in a window.
    if (nums[right] == 0) {
      currentFlip--
    }

    // A negative k denotes we have consumed all allowed flips and window has
    // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
    if (currentFlip < 0) {
      // If the left element to be thrown out is zero we increase k.
      if (nums[left] == 0) {
        currentFlip++
      }
      left++
    }

  }

  return nums.size - left
}