fun main() {
//  println(permute(intArrayOf(2, 3, 5)))
//  println(findMissingRanges(intArrayOf(), 0, 0))
//  println(uniquePaths(1, 1))
//  println(romanToInt("MCMXCIV"))
//  println(largestNumber(intArrayOf(3, 30, 34, 5, 9)))
//  val tree = TreeNode(10)
//  tree.left = TreeNode(5)
//  tree.right = TreeNode(15)
//  tree.left?.left = TreeNode(4)
//  tree.left?.right = TreeNode(7)
//  println(minDiffInBST(tree))
//  println(shipWithinDays(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 4))
//  println(maxLength(intArrayOf(9, 7, 5), 4))
//  val tree = TreeNode(1)
//  tree.left = TreeNode(2)
//  tree.right = TreeNode(3)
//  tree.left?.left = TreeNode(4)
//  tree.right?.left = TreeNode(2)
//  tree.right?.left?.left = TreeNode(4)
//  tree.right?.right = TreeNode(4)
//  println(findDuplicateSubtrees(tree))
//  val result = twoSum(intArrayOf(3, 2, 4), 7)
//  val result = sortedSquares(intArrayOf(-3, 3))
//  val result = equalSubstring("abcd", "bcdf", 3)
//  val result = compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c'))
//  val result = groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
//  val result = maximumSum(intArrayOf(10,12,19,14))
//  val node = ListNode(5)
//  node.next = ListNode(4)
//  node.next!!.next = ListNode(2)
//  node.next!!.next!!.next = ListNode(1)
//  node.next!!.next!!.next!!.next = null
//  val result1 = simplifyPath("/home")
//  val result2 = simplifyPath("/../")
//  val result3 = simplifyPath("/home//foo/")
//  println(result1)
//  println(result2)


//  val test = backspaceCompare("#ab#c", "acd#")
//  val tree = TreeNode(1)
//  tree.left = TreeNode(2)
//  tree.right = TreeNode(3)
//  tree.left?.left = TreeNode(5)
//  tree.right?.right = TreeNode(4)
//  val test = rightSideView(tree)
//  val test = findCircleNum(arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)))
//  val test = validPath(10, arrayOf(intArrayOf(4, 5), intArrayOf(4, 0), intArrayOf(0, 9), intArrayOf(6, 4)), 5, 9)
//  val test = nearestExit(arrayOf(charArrayOf('+', '+', '.', '+'), charArrayOf('.','.','.','+'), charArrayOf('+', '+', '+', '.')), intArrayOf(1, 2))
//  val test = nearestExit(arrayOf(charArrayOf('+', '+', '+'), charArrayOf('.','.','.'), charArrayOf('+', '+', '+')), intArrayOf(1, 0))
//  val test = openLock(arrayOf("0201","0101","0102","1212","2002"), "0202")
//  val test = canReach(intArrayOf(4,2,3,0,3,1,2), 5)
//  val test = findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1))
//  val test = coinChange(intArrayOf(1, 2, 5), 11)
//  var test = StringBuilder()

//  val result = shortestPathLengthBFS(arrayOf(intArrayOf(1, 2, 3), intArrayOf(0), intArrayOf(0), intArrayOf(0)))
//  println(result)

//  println(uncompress("10(ab)")) // ababab
//  println(countNicePairs(intArrayOf(13, 10, 35, 24, 76)))
//  println(maxLengthBetweenEqualCharacters("cbzxy"))
//  print(maximumLengthSubstring("bcbbbcba"))
//  var obj = ExamRoom(10)
//  println(obj.seat())
//  println(obj.seat())
//
//  println(obj.seat())
//
//  println(obj.seat())
//
//  println(obj.leave(4))
//  println(obj.seat())
//  println(lengthOfLongestSubstringTwoDistinct("ccaabbb"))
//  println(countStudents(intArrayOf(1, 1, 1, 0, 0, 1), intArrayOf(1, 0, 0, 0, 1, 1)))
//  val catalog: MutableList<MutableList<String>> = mutableListOf(
//    mutableListOf("Books", "Classics", "Fiction"),
//    mutableListOf("Electronics", "Cell Phones", "Computers", "Ultimate item"),
//    mutableListOf("Grocery", "Beverages", "Snacks"),
//    mutableListOf("Snacks", "Chocolate", "Sweets"),
//    mutableListOf("root", "Books", "Electronics", "Grocery")
//  )
//
//  val updates: MutableList<MutableList<String>> = mutableListOf(
//    mutableListOf("Snacks", "Marmalade"),
//    mutableListOf("Fiction", "Harry Potter"),
//    mutableListOf("root", "T-shirts"),
//    mutableListOf("T-shirts", "CodeSignal")
//  )
//  println(solution(catalog, updates))
//    println(findRelativeRanks(intArrayOf(10, 3, 8, 9, 4)))
    println("variableTest2Name".snakeCase())
    println("variableTest2Name".snakeCase1())
    println("businessStreetAddressLine1".snakeCase())
    println("businessStreetAddressLine1".snakeCase1())

}

fun String.snakeCase(): String {
    return this.replace(Regex("([a-z])([A-Z0-9])"), "$1_$2")
        .replace(Regex("([A-Z])([A-Z][a-z])"), "$1_$2")
        .lowercase()
}

fun String.snakeCase1(): String {
    return this.replace(Regex("([a-z0-9])([A-Z])"), "$1_$2")  // Handle lowercase/number to uppercase
        .replace(Regex("([A-Za-z])([0-9])"), "$1_$2")        // Handle letter to number transitions
        .replace(Regex("([A-Z])([A-Z][a-z])"), "$1_$2")      // Handle consecutive uppercase letters (e.g., HTTPResponse)
        .lowercase()
}