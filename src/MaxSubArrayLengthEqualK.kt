/**
 * Leetcode problems: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k
 * Date: Apr 22nd, 2025
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun maxSubArrayLen(nums: IntArray, k: Int): Int {
  var prefixSum = 0
  var longestSubarray = 0
  val indices = mutableMapOf<Int, Int>()
  for (i in nums.indices) {
    prefixSum += nums[i]

    // Check if the current prefix sum is equal to k
    if (prefixSum == k) {
      longestSubarray = i + 1
    }

    // Store the first occurrence of each prefix sum
    if (!indices.containsKey(prefixSum)) {
      indices[prefixSum] = i
    }

    // Check if there is a prefix sum that, when subtracted from the current prefix sum, equals k
    if (indices.containsKey(prefixSum - k)) {
      longestSubarray = maxOf(longestSubarray, i - indices[prefixSum - k]!!)
    }
  }

  return longestSubarray
}