
/**
 * Leetcode problems: https://leetcode.com/problems/next-greater-element-i/description/
 * Date: Mar 8th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * The entire nums2 array (of size n) is scanned only once. Each of the stack's nn elements are pushed and popped exactly once.
 * The nums1array is also scanned only once. All together this requires O(n+n+m) time.
 * Since nums1 must be a subset of nums2, we know m must be less than or equal to n. Therefore, the time complexity can be simplified to O(n).
 * Space complexity: O(n)
 */

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
  val stack = ArrayDeque<Int>()
  val map = mutableMapOf<Int, Int>()
  for (i in nums2.indices) {
    while (stack.isNotEmpty() && nums2[i] > stack.last()) {
      map.put(stack.removeLast(), nums2[i])
    }

    stack.addLast(nums2[i])
  }

  // The elements remaining in the stack are the ones for which no next greater element exists in the nums2nums2nums2 array
  while (stack.isNotEmpty()) {
    map[stack.removeLast()] = -1
  }

  // Iterate over the nums1nums1nums1 array to find the corresponding results from mapmapmap directly.
  val result = IntArray(nums1.size)
  for (i in nums1.indices) {
    result[i] = map[nums1[i]]!!
  }

  return result
}