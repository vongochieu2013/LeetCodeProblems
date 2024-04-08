/**
 * Leetcode problems: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 * Date: Feb 28th, 2023
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Iterate through the sandwiches array:
    If the current sandwich is a circle sandwich (value is 0) and there are no students who want circle sandwiches (circleStudentCount is 0), return squareStudentCount.
    If the current sandwich is square (value is 1) and there are no students who want square sandwiches (squareStudentCount is 0), return circleStudentCount.
    If the current sandwich matches a student's preference:
    If the current sandwich is a circle sandwich (value is 0), decrement circleStudentCount.
    Otherwise, the current sandwich is square (value is 1), decrement squareStudentCount.
    If the loop completes without returning, it means that all students received a sandwich, return 0.
 */
fun countStudents(students: IntArray, sandwiches: IntArray): Int {
  var circleStudentCount = 0
  var squareStudentCount = 0

  // Count the number of students who want each type of sandwich
  for (student in students) {
    if (student == 0) {
      circleStudentCount++
    } else {
      squareStudentCount++
    }
  }

  // Serve sandwiches to students
  for (sandwich in sandwiches) {
    // No student wants the circle sandwich on top of the stack
    if (sandwich == 0 && circleStudentCount == 0) {
      return squareStudentCount
    }
    // No student wants the square sandwich on top of the stack
    if (sandwich == 1 && squareStudentCount == 0) {
      return circleStudentCount
    }

    // Decrement the count of the served sandwich type
    if (sandwich == 0) {
      circleStudentCount--
    } else {
      squareStudentCount--
    }
  }

  // Every student received a sandwich
  return 0
}