package dota2Senate

import java.util.LinkedList
import java.util.Queue

class Solution {
    fun predictPartyVictory(senate: String): String {
        var queue: Queue<Char> = LinkedList()
        var queuePrev: Queue<Char> = LinkedList()
        var direVotes = 0
        var radiantVotes = 0
        for (c in senate) {
            queuePrev.add(c)
        }
        while (true) {
            for (senator in queuePrev) {
                if (senator == 'R') {
                    if (direVotes > 0) {
                        direVotes--
                    } else {
                        queue.add('R')
                        radiantVotes++
                    }
                } else {
                    if (radiantVotes > 0) {
                        radiantVotes--
                    } else {
                        queue.add('D')
                        direVotes++
                    }
                }
            }
            if (direVotes >= queue.size) {
                return "Dire"
            }
            if (radiantVotes >= queue.size) {
                return "Radiant"
            }
            queuePrev = queue
            queue = LinkedList()
        }
    }
}

fun main() {
    println(Solution().predictPartyVictory("RDR"))
}