import java.util.LinkedList

/**
 * Leetcode problems: https://leetcode.com/problems/design-snake-game/
 * Date: Apr 9th, 2024
 * Author: Hieu Vo
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
class SnakeGame(val width: Int, val height: Int, val food: Array<IntArray>) {

  private val snakeMap = hashMapOf<Pair<Int, Int>, Boolean>()
  private val snake = LinkedList<Pair<Int, Int>>()
  private var foodIndex = 0
  init {
    snakeMap[Pair(0, 0)] = true
    snake.offerLast(Pair(0, 0))
  }

  fun move(direction: String): Int {
    val snakeCell = snake.peekFirst()
    var newHeadRow = snakeCell.first
    var newHeadColumn = snakeCell.second

    when (direction) {
      "U" -> newHeadRow--
      "D" -> newHeadRow++
      "L" -> newHeadColumn--
      "R" -> newHeadColumn++
    }

    val newHead = Pair(newHeadRow, newHeadColumn)
    val currentTail = snake.peekLast()

    // Boundary conditions.
    val rowCrossBoundary = newHeadRow < 0 || newHeadRow >= height
    val heightCrossBoundary = newHeadColumn < 0 || newHeadColumn >= width

    // Checking if the snake bites itself.
    val bitesItself = snakeMap.containsKey(newHead) && !(newHead.first == currentTail.first && newHead.second == currentTail.second)

    // If any of the terminal conditions are satisfied, then we exit with rcode -1.
    if (rowCrossBoundary || heightCrossBoundary || bitesItself) {
      return -1
    }

    // If there's an available food item and it is on the cell occupied by the snake after the move,
    // eat it.
    if (this.foodIndex < food.size && food[foodIndex][0] == newHeadRow && food[foodIndex][1] == newHeadColumn) {
      foodIndex++
    } else {
      snake.pollLast()
      snakeMap.remove(currentTail)
    }

    // Add new head
    snake.addFirst(newHead)

    // Add the head into our set
    snakeMap[newHead] = true

    return snake.size - 1
  }

}