/**
 * Leetcode problems: https://leetcode.com/problems/find-pivot-index/
 * Date: March 1st, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(logn)
 * Create a function heapify that takes an array arr, size n, and index i as input.

Initialize largest as i.
Calculate the left child of node i as 2 * i + 1 and the right child as 2 * i + 2.
If the left child of node i is less than n and the value of the left child is greater than the value at largest, then set largest to left.
If the right child of node i is less than n and the value of the right child is greater than the value at largest, then set largest to right.
If largest is not equal to i, then swap the values at i and largest, and call heapify on the affected sub-tree rooted at largest.
Create a function heapSort that takes an array arr as input.

Initialize n as the size of the array.
Build the max heap by calling heapify function on each node (except leaf nodes).
Then, traverse the elements of the array arr from end to beginning, and for each element swap the root with the last element and call heapify on the reduced heap to make sure it remains a max heap.
Call heapSort on the array nums.

Return the sorted array nums.
 */
fun sortArrayHeapSort(nums: IntArray): IntArray {
  heapSort(nums)
  return nums
}

private fun heapSort(nums: IntArray) {
  val n = nums.size

  // // Build heap; heapify (top-down) all elements except leaf nodes.
  for (i in n / 2 - 1 downTo 0) {
    heapify(nums, n, i)
  }

  // Traverse the index one by one, swap with the first index, and
  for (i in n - 1 downTo 0) {
    swap(nums, 0, i)
    // call max heapify on the reduced heap.
    heapify(nums, i, 0)
  }
}

// Function to heapify a subtree (in top-down order) rooted at index i.
private fun heapify(nums: IntArray, n: Int, i: Int) {
  val left = 2 * i + 1
  val right = 2 * i + 2
  var largest = i

  if (left < n && nums[left] > nums[largest]) {
    largest = left
  }

  if (right < n && nums[right] > nums[largest]) {
    largest = right
  }

  // If largest is not root swap root with largest element
  // Recursively heapify the affected sub-tree (i.e. move down).
  if (largest != i) {
    swap(nums, largest, i)
    heapify(nums, n, largest)
  }
}

private fun swap(nums: IntArray, left: Int, right: Int) {
  val swap = nums[left]
  nums[left] = nums[right]
  nums[right] = swap
}