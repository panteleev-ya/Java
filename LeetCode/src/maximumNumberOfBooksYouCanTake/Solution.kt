package maximumNumberOfBooksYouCanTake

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maximumBooks(books: IntArray): Long {
        var maxBooksTaken = 0L
        var i = books.size - 1
        while (i >= 0) {
            var booksTaken = 0L
            var lastBooksTaken = Int.MAX_VALUE
            for (j in i downTo 0) {
                val booksTakenShelf = min(lastBooksTaken - 1, books[j])
                if (booksTakenShelf <= 0) {
                    i = j
                    break
                }
                booksTaken += booksTakenShelf
                lastBooksTaken = booksTakenShelf
            }
            maxBooksTaken = max(maxBooksTaken, booksTaken)
            i--
        }
        return maxBooksTaken
    }
}

fun main() {
//    println(Solution().maximumBooks(intArrayOf(8, 2, 3, 7, 3, 4, 0, 1, 4, 3)))
    println(Solution().maximumBooks(intArrayOf(3, 4, 5, 6, 7, 4, 5)))
//    println(Solution().maximumBooks(intArrayOf(7, 0, 3, 4, 5)))
}
