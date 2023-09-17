/**
 * Leetcode problems: https://leetcode.com/problems/predict-the-winner/
 * Date: Jul 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O(2^n)
 * Space complexity: O(n)
 * Recursive solution:
 *  Define maxDiff(left, right) as the maximum score difference the current player can achieve.
 *  If left = right, return nums[left].
 *  Otherwise, the current player can pick nums[left] or nums[right], the maximum score difference he can get is the
 *  larger one from nums[left] - maxDiff(left + 1, right) and nums[right] - maxDiff(left, right - 1).
 *  Return if maxDiff(0, n - 1) >= 0.
 *  This call is from the perspective of the first player, and the first player is the winner if the players have the same score (difference of 0).
 */
fun predictTheWinner(nums: IntArray): Boolean {
  return maxDiff(0, nums.size - 1, nums) >= 0
}

fun maxDiff(left: Int, right: Int, nums: IntArray): Int {
  if (left == right) {
    return nums[left]
  }

  val takeLeft = nums[left] - maxDiff(left + 1, right, nums)
  val takeRight = nums[right] - maxDiff(left, right - 1, nums)

  return Math.max(takeLeft, takeRight)
}