import java.util.PriorityQueue

/**
 * Leetcode problems: https://leetcode.com/problems/furthest-building-you-can-reach/description/?envType=daily-question&envId=2024-02-18
 * Date: Feb 18th, 2024
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

// [4,2,7,6,9,14,12], bricks = 5, ladders = 1
// brickAllocation 5


fun furthestBuilding1(heights: IntArray, bricks: Int, ladders: Int): Int {
  val brickAllocations = PriorityQueue<Int> { a, b -> b - a }
  var currentBricks = bricks
  var currentLadders = ladders
  for (i in 0 until heights.size - 1) {
    val climb = heights[i + 1] - heights[i]

    if (climb <= 0) {
      continue
    }

    // Allocate brick for this climb
    brickAllocations.add(climb)
    currentBricks -= climb

    if (currentBricks < 0 && currentLadders == 0) {
      return i
    }

    if (currentBricks < 0) {
      currentBricks += brickAllocations.remove()
      currentLadders--
    }
  }

  return heights.size - 1
}

fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
  var currentBricks = bricks
  val ladderAllocations = PriorityQueue<Int>()
  for (i in 0 until heights.size - 1) {
    var climb = heights[i + 1] - heights[i]

    // If this is a jump down, skip
    if (climb <= 0) {
      continue
    }

    // Allocate a ladder for this climb
    ladderAllocations.add(climb)

    // If we haven't gone the number of ladders, nothing else to do
    if (ladderAllocations.size <= ladders) {
      continue
    }

    // Otherwise, we will need to take a climn out of ladder allocations
    currentBricks -= ladderAllocations.remove()

    // If this caused bricks to go negative, we can't get to i + 1
    if (currentBricks < 0) {
      return i
    }

  }
  return heights.size - 1
}