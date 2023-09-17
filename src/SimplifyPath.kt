/**
 * Leetcode problems: https://leetcode.com/problems/simplify-path/description/
 * Date: Mar 6th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun simplifyPath(path: String): String {
  // Initialize a stack
  val stack = ArrayDeque<String>()
  val actions = path.split("/")

  // Split the input string on "/" as the delimiter
  // and process each portion one by one
  for (action in actions) {

    // A no-op for a "." or an empty string
    if (action == "." || action == "") {
      continue
    } else if (action == "..") {

      // If the current component is a "..", then
      // we pop an entry from the stack if it's non-empty
      if (stack.isNotEmpty()){
        stack.removeLast()
      }
    } else {

      // Finally, a legitimate directory name, so we add it
      // to our stack
      stack.addLast(action)
    }
  }

  // Stitch together all the directory names together
  return "/" + stack.joinToString("/")
}