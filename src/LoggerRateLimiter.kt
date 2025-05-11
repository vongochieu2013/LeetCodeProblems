/**
 * Leetcode problems: https://leetcode.com/problems/add-to-array-form-of-integer/description/
 * Date: Feb 15th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Logger() {
  private val messageMap: MutableMap<String, Int> = mutableMapOf()

  fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
    if (messageMap.containsKey(message)) {
      val lastTimestamp = messageMap[message]!!
      if (timestamp - lastTimestamp < 10) {
        return false
      } else {
        messageMap[message] = timestamp
        return true
      }
    }

    messageMap[message] = timestamp
    return true
  }
}