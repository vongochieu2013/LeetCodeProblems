import java.lang.Exception

/**
 * Leetcode problems: https://leetcode.com/problems/destination-city/description/
 * Date: March 5rd, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun destCity(paths: List<List<String>>): String {
  val startCities = mutableSetOf<String>()

  // Add start city into our set
  for (path in paths) {
    startCities.add(path[0])
  }

  // Check the destination city in which city not occurs
  // Since it is guaranteed that the graph of paths forms a line without any loop
  for (path in paths) {
    if (!startCities.contains(path[1])) {
      return path[1]
    }
  }

  throw RuntimeException("There must be destination city")
}