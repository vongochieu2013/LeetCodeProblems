/**
 * Leetcode problems: https://leetcode.com/problems/most-popular-video-creator/description/
 * Date: October 7th, 2024
 * Author: Hieu Vo
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */

data class CreatorInfo(
  val name: String,
  var mostViewedVideoId: String,
  var totalViews: Long,
  var maxViews: Long
)

fun mostPopularCreator(creators: Array<String>, ids: Array<String>, views: IntArray): List<List<String>> {
  // Using a TreeMap to maintain lexicographical order of creators
  val creatorMap = sortedMapOf<String, CreatorInfo>()
  var globalMaxViews = 0L

  for (i in creators.indices) {
    val creatorName = creators[i]
    val videoId = ids[i]
    val viewCount = views[i].toLong()

    if (creatorMap[creatorName] == null) {
      // If the creator is not present, add a new CreatorInfo
      creatorMap[creatorName] = CreatorInfo(creatorName, videoId, viewCount, viewCount)
    } else {
      val creatorInfo = creatorMap[creatorName]!!
      // Update the most viewed video if necessary
      if (viewCount > creatorInfo.maxViews || (viewCount == creatorInfo.maxViews && videoId < creatorInfo.mostViewedVideoId)) {
        creatorInfo.mostViewedVideoId = videoId
        creatorInfo.maxViews = viewCount
      }

      // Update the total views
      creatorInfo.totalViews += viewCount
    }

    // Update the global maximum total views
    globalMaxViews = maxOf(globalMaxViews, creatorMap[creatorName]!!.totalViews)
  }

  // Prepare the result list
  val result = mutableListOf<List<String>>()
  for (creatorInfo in creatorMap.values) {
    if (creatorInfo.totalViews == globalMaxViews) {
      result.add(listOf(creatorInfo.name, creatorInfo.mostViewedVideoId))
    }
  }

  return result
}
