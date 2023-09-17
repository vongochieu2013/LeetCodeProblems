/**
 * Leetcode problems: https://leetcode.com/problems/top-k-frequent-words/description/
 * Date: Apr 18th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogk)
 * Space complexity: O(n + k)
 */
//fun topKFrequent(words: Array<String>, k: Int): List<String> {
//  val counts = mutableMapOf<String, Int>()
//  words.forEach { w ->
//    counts[w] = counts.getOrDefault(w, 0) + 1
//  }
//
//  val minHeap = PriorityQueue<String>() {
//    a, b ->
//    b.compareTo(a).takeIf { counts[a]!! == counts[b]!! } ?: (counts[a]!! - counts[b]!!)
//  }
//
//  counts.keys.forEach {
//    minHeap.offer(it)
//    if (minHeap.size > k) {
//      minHeap.poll()
//    }
//  }
//
//  val result = mutableListOf<String>()
//  while (!minHeap.isEmpty()) {
//    result.add(minHeap.poll())
//  }
//
//  return result.reversed()
//}

fun topKFrequent(words: Array<String>, k: Int): List<String> {
  val counts = mutableMapOf<String, Int>()
  words.forEach { w ->
    counts[w] = counts.getOrDefault(w, 0) + 1
  }

  val n = counts.size
  val result = mutableListOf<String>()
  counts.keys.forEach {
    result.add(it)
  }
  quickSelectString(0, n - 1, n - k, result, counts)

  val ans = result.subList(n - k, n)
  ans.sortWith(Comparator { a, b -> b.compareTo(a).takeIf { counts[a]!! == counts[b]!! } ?: (counts[a]!! - counts[b]!!) })
  return result.subList(n - k, n)
}

private fun quickSelectString(left: Int, right: Int, kSmallest: Int, result: MutableList<String>, counts: Map<String, Int>) {
  if (left == right) {
    return
  }

  var pivot = left + (right - left) / 2

  pivot = partitionString(left, right, pivot, result, counts)
  if (pivot == kSmallest) {
    return
  } else if (pivot < kSmallest) {
    quickSelectString(pivot + 1, right, kSmallest, result, counts)
  } else {
    quickSelectString(left, pivot - 1, kSmallest, result, counts)
  }
}

private fun partitionString(left: Int, right: Int, pivot: Int, result: MutableList<String>, counts: Map<String, Int>): Int {
  val pivotCounts = counts[result[pivot]]!!

  swap123(pivot, right, result)
  var storeIndex = left
  val comparator = MyComparator()
  for (i in left..right) {
    if (counts[result[i]]!! < pivotCounts) {
      swap123(i, storeIndex, result)
      storeIndex++
    }
  }

  swap123(storeIndex, right, result)

  return storeIndex
}

private fun swap123(x: Int, y: Int, result: MutableList<String>) {
  val temp = result[x]
  result[x] = result[y]
  result[y] = temp
}

internal class MyComparator : Comparator<Map.Entry<String, Int>> {
  override fun compare(e1: Map.Entry<String, Int>, e2: Map.Entry<String, Int>): Int {
    val word1 = e1.key
    val freq1 = e1.value
    val word2 = e2.key
    val freq2 = e2.value
    return if (freq1 != freq2) {
      freq2 - freq1
    } else {
      word1.compareTo(word2)
    }
  }
}