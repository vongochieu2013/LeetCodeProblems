import java.util.TreeSet

/**
 * Leetcode problems: https://leetcode.com/problems/next-closest-time/
 * Date: Feb 22nd, 2025
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

fun nextClosestTime(time: String): String {
  // Remove the colon from the time string, e.g., "20:48" becomes "2048"
  val digits = time.filter { it != ':' }

  // Create a TreeSet to store unique digits in sorted order
  val set = TreeSet<Char>()
  for (digit in digits) {
    set.add(digit)
  }

  // Try to increment the minute's ones digit (position 4)
  val current = time[4]
  // Get the next valid digit for the minute ones, with a limit of '9'
  val nextMinute = next(set, current, '9')
  if (nextMinute > current) {
    // If a valid higher digit is found, keep the rest of the time unchanged and update minute ones
    return time.substring(0, 4) + nextMinute
  }

  // If the minute's ones digit can't be incremented, try the minute's tens digit (position 3)
  val nextTenMinute = next(set, time[3], '5')
  if (nextTenMinute > time[3]) {
    // If a valid higher digit is found, update minute tens and set minute ones to the smallest available digit
    return time.substring(0, 3) + nextTenMinute + set.first()
  }

  // If minutes cannot be updated, try to update the hour's ones digit (position 1)
  // The limit for the hour's ones digit depends on the hour's tens digit:
  // If the hour tens is '2', then the valid range is up to '3' (since 23 is the maximum hour)
  val nextHour = next(set, time[1], if (time[0] == '2') '3' else '9')
  if (nextHour > time[1]) {
    // If a valid higher digit is found, update the hour's ones digit
    // Reset both minute digits to the smallest available digit
    return time.substring(0, 1) + nextHour + ":" + set.first() + set.first()
  }

  // Finally, if no other digit could be incremented, update the hour's tens digit (position 0)
  val nextTenHour = next(set, time[0], '2')
  // Construct the new time with the updated hour tens and smallest digits for hour ones and minutes
  return nextTenHour.toString() + set.first() + ":" + set.first() + set.first()
}

private fun next(set: TreeSet<Char>, current: Char, limit: Char): Char {
  // Find the next higher digit in the set after the current digit
  val next = set.higher(current)
  // If such a digit exists and it does not exceed the allowed limit, return it.
  // Otherwise, return the smallest digit in the set to "roll over."
  return if (next != null && next <= limit) {
    next
  } else {
    set.first()
  }
}