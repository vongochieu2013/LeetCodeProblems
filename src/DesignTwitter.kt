import java.lang.Math.max
import java.util.PriorityQueue
import java.util.concurrent.ConcurrentHashMap

class Twitter {
  private val tweets = mutableMapOf<Int, MutableList<Tweet>>()
  private val followers = mutableMapOf<Int, MutableSet<Int>>()
  private var timestamp = 0

  fun postTweet(userId: Int, tweetId: Int) {
    tweets.putIfAbsent(userId, mutableListOf())
    tweets[userId]!!.add(Tweet(tweetId, timestamp++))
  }

  fun getNewsFeed(userId: Int): List<Int> {
    val maxHeap = PriorityQueue<Tweet> { a, b -> b.time - a.time }

    // Ensure the user follows themselves
    val userFollows = followers.getOrPut(userId) { mutableSetOf() }.apply {
      add(userId)
    }

    // Add tweets from the user and followed users
    for (followeeId in userFollows) {
      tweets[followeeId]?.let { followeeTweets ->
        val start = followeeTweets.size - 10
        for (i in max(0, start) until followeeTweets.size) {
          maxHeap.add(followeeTweets[i])
        }
      }
    }

    val result = mutableListOf<Int>()
    while (result.size < 10 && maxHeap.isNotEmpty()) {
      result.add(maxHeap.poll().tweetId)
    }

    return result
  }

  fun follow(followerId: Int, followeeId: Int) {
    if (followerId == followeeId) return
    followers.putIfAbsent(followerId, mutableSetOf())
    followers[followerId]!!.add(followeeId)
  }

  fun unfollow(followerId: Int, followeeId: Int) {
    if (followerId == followeeId) return
    followers[followerId]?.remove(followeeId)
  }
}

data class Tweet(
  val tweetId: Int,
  val time: Int
)