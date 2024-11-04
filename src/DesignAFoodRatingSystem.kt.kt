/**
 * Leetcode problems: https://leetcode.com/problems/design-a-food-rating-system
 * Date: October 7th, 2024
 * Author: Hieu Vo
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

import java.util.TreeSet

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
  private val cousineFoodMap = HashMap<String, TreeSet<RatedFood>>()
  private val foodRatingMap = HashMap<String, RatedFood>()

  init {
    for (i in foods.indices) {
      val ratedFood = RatedFood(cuisines[i], foods[i], ratings[i])
      val set = cousineFoodMap.getOrPut(ratedFood.cousine) { TreeSet<RatedFood>() }
      set.add(ratedFood)
      foodRatingMap[ratedFood.food] = ratedFood
    }
  }

  fun changeRating(food: String, newRating: Int) {
    foodRatingMap[food]?.let { ratedFood ->
      cousineFoodMap[ratedFood.cousine]?.let { set ->
        set.remove(ratedFood)
        ratedFood.rating = newRating
        set.add(ratedFood)
      }
    }
  }

  fun highestRated(cuisine: String): String =
    cousineFoodMap[cuisine]?.last()?.food ?: throw Exception()
}

data class RatedFood(
  val cousine: String,
  val food: String,
  var rating: Int
) : Comparable<RatedFood> {
  override fun compareTo(other: RatedFood): Int {
    val k = rating - other.rating
    return if (k != 0) k else other.food.compareTo(food)
  }
}