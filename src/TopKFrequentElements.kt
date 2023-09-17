import java.util.*

/**
 * Leetcode problems: https://leetcode.com/problems/top-k-frequent-elements/
 * Date: Apr 18th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogk) and O(n) best case O(n^2) worse case
 * Space complexity: O(n + k) or O(n)
 */
fun topKFrequent(nums: IntArray, k: Int): IntArray {
  val map = mutableMapOf<Int, Int>()
  nums.forEach {
    map[it] = map.getOrDefault(it, 0) + 1
  }

  val heap = PriorityQueue<Int>() {a , b -> map.get(a)!! - map.get(b)!! }
  for (num in map.keys) {
    heap.offer(num)
    if (heap.size > k) {
      heap.poll()
    }
  }

  val result = IntArray(k)
  (0 until k).forEach { it ->
    result[it] = heap.poll()
  }

  return result
}

fun topKFrequent1(nums: IntArray, k: Int): IntArray {
  val map = mutableMapOf<Int, Int>()
  nums.forEach {
    map[it] = map.getOrDefault(it, 0) + 1
  }

  val n = map.size
  val unique = IntArray(n)
  map.keys.forEachIndexed { index, i ->
    unique[index] = i
  }

  // kth top frequent element is (n - k)th less frequent.
  // Do a partial sort: from less frequent to the most frequent, till
  // (n - k)th less frequent element takes its place (n - k) in a sorted array.
  // All element on the left are less frequent.
  // All the elements on the right are more frequent.
  quickSelect(0, n - 1, n - k, unique, map)

  return unique.copyOfRange(n - k, n)
}

private fun swap(unique: IntArray, a: Int, b: Int) {
  val temp = unique[a]
  unique[a] = unique[b]
  unique[b] = temp
}

private fun quickSelect(left: Int, right: Int, kSmallest: Int, unique: IntArray, map: MutableMap<Int, Int>) {
  if (left == right)
    return

  var pivotIndex = left + (right - left) / 2

  pivotIndex = partition(left, right, pivotIndex, unique, map)

  if (kSmallest == pivotIndex) {
    return
  } else if (pivotIndex < kSmallest) {
    quickSelect(pivotIndex + 1, right, kSmallest, unique, map)
  } else {
    quickSelect(left, pivotIndex - 1, kSmallest, unique, map)
  }
}

private fun partition(left: Int, right: Int, pivotIndex: Int, unique: IntArray, map: MutableMap<Int, Int>): Int {
  val pivotFrequency = map[unique[pivotIndex]]!!

  // move pivot to end
  swap(unique, pivotIndex, right)
  var storeIndex = left
  for (i in left..right) {
    if (map[unique[i]]!! < pivotFrequency) {
      swap(unique, i, storeIndex)
      storeIndex++
    }
  }

  swap(unique, right, storeIndex)

  return storeIndex
}
