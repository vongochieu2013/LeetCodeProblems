import java.util.Arrays

/**
 * Leetcode problems: https://leetcode.com/problems/design-phone-directory/description/
 * Date: Feb 27th, 2024
 * Author: Hieu Vo
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
class PhoneDirectory(maxNumbers: Int) {
  val dir = BooleanArray(maxNumbers)
  val queue = ArrayDeque<Int>()

  init {
    Arrays.fill(dir, true)
    for (i in 0 until maxNumbers) {
      queue.addLast(i)
    }
  }

  fun get(): Int {
    if (queue.isEmpty()) {
      return -1
    }

    val slot = queue.removeFirst()
    dir[slot] = false
    return slot
  }

  fun check(number: Int): Boolean {
    return dir[number]
  }

  fun release(number: Int) {
    if (dir[number]) {
      return
    }

    queue.addLast(number)
    dir[number] = true
  }

}
