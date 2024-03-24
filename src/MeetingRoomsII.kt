import java.util.Arrays

/**
 * Leetcode problems: https://leetcode.com/problems/meeting-rooms-ii/
 * Date: Mar 20th, 2023
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
fun minMeetingRooms(intervals: Array<IntArray>): Int {
  val startTimes = IntArray(intervals.size)
  val endTimes = IntArray(intervals.size)

  for (i in intervals.indices) {
    startTimes[i] = intervals[i][0]
    endTimes[i] = intervals[i][1]
  }

  Arrays.sort(startTimes)
  Arrays.sort(endTimes)

  var meetingRoom = 0
  var end = 0
  for (start in intervals.indices) {
    if (startTimes[start] < endTimes[end]) {
      meetingRoom++
    } else {
      end++
    }
  }

  return meetingRoom
}