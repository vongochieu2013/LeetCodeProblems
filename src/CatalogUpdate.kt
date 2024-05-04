/**
 * Leetcode problems: https://app.codesignal.com/challenge/fhwFgHYZmsfB8hz8F?solutionId=98nGMuR7d9zd2Wh6F
 * Date: Apr 17th, 2023
 * Author: Hieu Vo
 * Time complexity: O(r x c)
 * Space complexity: O(r x c)
 */
fun solution(catalog: MutableList<MutableList<String>>, updates: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
  if (updates.size == 0) return catalog

  val catalogMap = hashMapOf<String, MutableList<String>>()
  for (i in 0 until catalog.size) {
    catalogMap[catalog[i][0]] = catalog[i].subList(1, catalog[i].size)
  }

  for (i in 0 until updates.size) {
    if (catalogMap.containsKey(updates[i][0])) {
//      val catalogItems = catalogMap[updates[i][0]]!!
//      catalogItems.add(updates[i][1])
      catalogMap[updates[i][0]]?.add(updates[i][1])
    } else {
      catalogMap[updates[i][0]] = mutableListOf(updates[i][1])
    }
  }

  val categoryList = catalogMap.keys.toMutableList()
  categoryList.sorted()

  val result = mutableListOf<MutableList<String>>()
  for (i in 0 until categoryList.size) {
    val key = categoryList[i]
    val items = catalogMap[key]!!
    items.sorted()
    items.add(0, key)
    if (key != "root") {
      result.add(items)
    } else {
      result.add(categoryList.size - 1, items)
    }
  }

  return result
}
