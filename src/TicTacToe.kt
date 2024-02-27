/**
 * Leetcode problems: https://leetcode.com/problems/design-tic-tac-toe/
 * Date: Jan 29st, 2024
 * Author: Hieu Vo
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
class TicTacToe(n: Int) {

  val rows = IntArray(n)
  val cols = IntArray(n)
  var diagonal = 0
  var antiDiagonal = 0
  val size = n

  fun move(row: Int, col: Int, player: Int): Int {
    val currentPlayer = if (player == 1) {
      1
    } else {
      -1
    }

    rows[row] += currentPlayer
    cols[col] += currentPlayer
    if (row == col) {
      diagonal += currentPlayer
    }

    if (col == size - 1 - row) {
      antiDiagonal += currentPlayer
    }

    if (Math.abs(rows[row]) == size ||
      Math.abs(cols[col]) == size ||
      Math.abs(diagonal) == size ||
      Math.abs(antiDiagonal) == size) {
      return player
    }

    return 0
  }

}
