/**
 * Leetcode problems: https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
 * Date: October 27th, 2024
 * Author: Hieu Vo
 * Time complexity:
 * Space complexity:
 */
fun removeSubfolders(folder: Array<String>): List<String> {
  class TrieNode {
    val children = hashMapOf<String, TrieNode>()
    var isEnd = false
  }

  fun buildTrie() : TrieNode {
    val root = TrieNode()
    for (str in folder) {
      var node = root
      var start = 1
      for (end in 1 .. str.length) {
        if (end == str.length || str[end] == '/') {
          val dir = str.substring(start, end)
          node = node.children.getOrPut(dir) { TrieNode() }
          if (node.isEnd) break
          start = end + 1
        }
      }
      node.isEnd = true
      if (node.children.keys.isNotEmpty()) {
        node.children.clear()
      }
    }
    return root
  }

  val root = buildTrie()
  val result = mutableListOf<String>()
  val sb = StringBuilder()

  fun dfs(node: TrieNode) {
    if (node.isEnd) {
      result.add(sb.toString())
      return
    }
    for ((key, node) in node.children) {
      val startIndex = sb.length
      sb.append("/$key")
      val endIndex = sb.length
      dfs(node)
      sb.delete(startIndex, endIndex)
    }
  }

  dfs(root)
  return result
}

fun main() {
  val folder = arrayOf("/a","/a/b","/c/d","/c/d/e","/c/f")
  println(removeSubfolders(folder))
}