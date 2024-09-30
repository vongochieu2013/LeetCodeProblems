/**
 * Leetcode problems: https://leetcode.com/problems/design-file-system/
 * Date: Jul 26th, 2024
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class FileSystem() {

  val map = hashMapOf<String, Int>()
  fun createPath(path: String, value: Int): Boolean {
    if (map.containsKey(path)) {
      return false
    }

    val parent = path.substring(0, path.lastIndexOf('/'))
    if (parent.isNotEmpty() && !map.containsKey(parent)) {
      return false
    }

    map[path] = value
    return true
  }

  fun get(path: String): Int {
    return map.getOrDefault(path, -1)
  }

}
