/**
 * Leetcode problems: https://leetcode.com/problems/count-vowel-strings-in-ranges/
 * Date: Jan 1st, 2025
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun candyCrush(board: Array<IntArray>): Array<IntArray> {
  val rows = board.size
  val cols = board[0].size
  var resultBoard = board
  var crushSet = mutableSetOf<Pair<Int, Int>>()
  while (crushSet.isNotEmpty()) {
    crush(resultBoard, crushSet)
    drop(board)
    crushSet = find(board)
  }

  return resultBoard
}

private fun crush(board: Array<IntArray>, crushSet: MutableSet<Pair<Int, Int>>) {
  for (crush in crushSet) {
    val (row, col) = crush
    board[row][col] = 0
  }
}

private fun find(board: Array<IntArray>): MutableSet<Pair<Int, Int>> {
  val rows = board.size
  val cols = board[0].size

  val crushSet = mutableSetOf<Pair<Int, Int>>()

  // Check vertically adjacent cells
  for (row in 1 until rows - 1) {
    for (col in 0 until cols) {
      if (board[row][col] == 0) {
        continue
      }
      if (board[row][col] == board[row - 1][col] &&  board[row][col] == board[row + 1][col]) {
        crushSet.add(Pair(row, col))
        crushSet.add(Pair(row - 1, col))
        crushSet.add(Pair(row + 1, col))
      }
    }
  }

  // Check horizontally adjacent cells
  for (row in 0 until rows) {
    for (col in 1 until cols - 1) {
      if (board[row][col] == 0) {
        continue
      }
      if (board[row][col] == board[row][col - 1] &&  board[row][col] == board[row][col + 1]) {
        crushSet.add(Pair(row, col))
        crushSet.add(Pair(row, col - 1))
        crushSet.add(Pair(row, col + 1))
      }
    }
  }

  return crushSet
}

private fun drop(board: Array<IntArray>) {
  for (col in 0 until board[0].size) {
    var lowestZero = -1

    // Iterate over each column
    for (row in board.size - 1 downTo 0) {
      if (board[row][col] == 0) {
        lowestZero = Math.max(lowestZero, row)
      } else if (lowestZero >= 0) {
        val temp = board[row][col]
        board[row][col] = board[lowestZero][col]
        board[lowestZero][col] = temp
        lowestZero--
      }
    }
  }
}