/**
 * Leetcode problems: https://app.codesignal.com/challenge/rWRckbbvwAnNqTnhC?solutionId=TNq2agyXge795twMB
 * Date: Apr 17th, 2023
 * Author: Hieu Vo
 * Time complexity: O(r x c)
 * Space complexity: O(r x c)
 */
private fun solution(hangar: MutableList<MutableList<Char>>): Int {
  val rows = hangar.size
  val cols = hangar[0].size
  val visited = MutableList(rows) { MutableList(cols) { false } }
  val canEscape = MutableList(rows) { MutableList(cols) { false } }

  for (r in 0 until rows) {
    for (c in 0 until cols) {
      if (!visited[r][c]) {
        simulateMovement(hangar, r, c, visited, canEscape)
      }
    }
  }

  // Count rooms from which Ratiorg cannot escape
  var trappedRooms = 0
  for (r in 0 until rows) {
    for (c in 0 until cols) {
      if (!canEscape[r][c]) trappedRooms++
    }
  }

  return trappedRooms
}

fun simulateMovement(hangar: MutableList<MutableList<Char>>, startRow: Int, startCol: Int, visited: MutableList<MutableList<Boolean>>, canEscape: MutableList<MutableList<Boolean>>) {
  var r = startRow
  var c = startCol
  val path = mutableListOf<Pair<Int, Int>>()

  while (r in 0 until hangar.size && c in 0 until hangar[0].size) {
    if (visited[r][c]) {
      if (canEscape[r][c]) {
        path.forEach { (pr, pc) -> canEscape[pr][pc] = true }
      }
      return
    }

    // Mark this room as visited and add to the path
    visited[r][c] = true
    path.add(Pair(r, c))

    // Move to the next room based on the direction
    when (hangar[r][c]) {
      'U' -> r--
      'D' -> r++
      'L' -> c--
      'R' -> c++
    }
  }

  // If we exit the loop, Ratiorg has escaped
  path.forEach { (pr, pc) -> canEscape[pr][pc] = true }
}
