/**
 * Leetcode problems: https://app.codesignal.com/challenge/udAmj5NKfnnBjsvur
 * Date: Apr 26th, 2023
 * Author: Hieu Vo
 * Time complexity: O(...)
 * Space complexity: O(...)
 */
private fun solution(birthdayDate: String): Int {
  val formatter = java.time.format.DateTimeFormatter.ofPattern("MM-dd-yyyy")
  val birthday = java.time.LocalDate.parse(birthdayDate, formatter)
  val initialDayOfWeek = birthday.dayOfWeek
  var nextYear = birthday.year + 1

  if (birthday.monthValue == 2 && birthday.dayOfMonth == 29) {
    // Special handling for leap year birthdays on February 29
    while (true) {
      try {
        val nextBirthday = java.time.LocalDate.of(nextYear, 2, 29)
        if (nextBirthday.dayOfWeek == initialDayOfWeek) {
          return nextYear - birthday.year
        }
        nextYear += 4  // Jump in steps of 4 years for leap years
      } catch (e: java.time.DateTimeException) {
        nextYear++
      }
    }
  } else {
    // Regular handling for all other birthdays
    while (true) {
      try {
        val nextBirthday = birthday.withYear(nextYear)
        if (nextBirthday.dayOfWeek == initialDayOfWeek) {
          return nextYear - birthday.year
        }
        nextYear++
      } catch (e: java.time.DateTimeException) {
        nextYear++
      }
    }
  }
}