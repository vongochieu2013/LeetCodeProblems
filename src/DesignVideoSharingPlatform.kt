import java.util.PriorityQueue
import java.util.concurrent.atomic.AtomicInteger

/**
 * Leetcode problems: https://leetcode.com/problems/design-log-storage-system/description/
 * Date: Aug 10 th, 2024
 * Author: Hieu Vo
 * Summary of Time Complexities:
 * upload(video: String): O(1)
 * remove(videoId: Int): O(log n)
 * watch(videoId: Int, startMinute: Int, endMinute: Int): O(m)
 * like(videoId: Int): O(1)
 * dislike(videoId: Int): O(1)
 * getLikesAndDislikes(videoId: Int): O(1)
 * getViews(videoId: Int): O(1)

 * Space complexity: O(n), where n is the number of videos uploaded
 */
data class Video(
  val id: Int,
  var likes: Int,
  var dislikes: Int,
  var views: Int,
  val video: String,
  val size: Int,
) {
  fun increaseLike(): Int {
    return this.likes++
  }

  fun increaseDislikes(): Int {
    return this.dislikes++
  }

  fun increaseViews(): Int {
    return this.views++
  }

  fun watch(startMinute: Int, endMinute: Int): String {
    val actualEndMinute = Math.min(endMinute + 1, size)
    return video.substring(startMinute, actualEndMinute)
  }
}

class VideoSharingPlatform() {
  private val id = AtomicInteger(-1)
  private val videos = mutableMapOf<Int, Video>() // Video ID -> Video
  private val lastDeleted = PriorityQueue<Int>() // MinHeap to store reusable IDs

  fun upload(video: String): Int {
    val currentId = if (!lastDeleted.isEmpty()) {
      lastDeleted.poll()
    } else {
      id.incrementAndGet()
    }
    videos[currentId] = Video(currentId, 0, 0, 0, video, video.length)
    return currentId
  }

  fun remove(videoId: Int) {
    if (!videos.containsKey(videoId))
      return

    videos.remove(videoId)
    lastDeleted.add(videoId)
  }

  fun watch(videoId: Int, startMinute: Int, endMinute: Int): String {
    if (!videos.containsKey(videoId))
      return "-1"

    val currentVideo = videos[videoId]!!
    currentVideo.increaseViews()
    return currentVideo.watch(startMinute, endMinute)
  }

  fun like(videoId: Int) {
    if (!videos.containsKey(videoId))
      return

    videos[videoId]!!.increaseLike()
  }

  fun dislike(videoId: Int) {
    if (!videos.containsKey(videoId))
      return

    videos[videoId]!!.increaseDislikes()  // No need to reassign
  }

  fun getLikesAndDislikes(videoId: Int): IntArray {
    if (!videos.containsKey(videoId))
      return intArrayOf(-1)

    val currentVideo = videos[videoId]!!
    return intArrayOf(currentVideo.likes, currentVideo.dislikes)
  }

  fun getViews(videoId: Int): Int {
    if (!videos.containsKey(videoId))
      return -1

    return videos[videoId]!!.views
  }
}