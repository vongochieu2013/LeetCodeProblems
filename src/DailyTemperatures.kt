/**
 * Leetcode problems: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 * Date: Mar 7th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Initialize an array answer with the same length as temperatures and all values initially set to 0.
 * Also, initialize an integer hottest = 0 to track the hottest temperature seen so far.
 *
 * Iterate backwards through the input.
 * At each index currDay, check if the current day is the hottest one seen so far. If it is, update hottest and move on. Otherwise, do the following:
 * - Initialize a variable days = 1 because the next warmer day must be at least one day in the future.
 * - While temperatures[currDay + days] <= temperatures[currDay]:
 * - Add answer[currDay + days] to days. This effectively jumps directly to the next warmer day.
 * - Set answer[currDay] = days.
 * Return answer.
 */
fun dailyTemperatures(temperatures: IntArray): IntArray {
  var hottest = 0
  val answers = IntArray(temperatures.size)
  for (currentDay in temperatures.size - 1 downTo 0) {
    val currentTemp = temperatures[currentDay]
    // This process does not work for a day that does not have a warmer day in the future. Therefore, we need to use a variable hottest to keep track of the hottest day seen so far.
    // If a day is warmer than hottest, then we know the answer for that day is 0, and we don't need to go through the process described above.
    if (currentTemp >= hottest) {
      hottest = currentTemp
      continue
    }

    var days = 1
    while (temperatures[currentDay + days] <= currentTemp) {

      // Use information from answer to search for the next warmer day
      days += answers[currentDay + days]
    }

    answers[currentDay] = days
  }

  return answers
}