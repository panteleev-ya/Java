package reorderDataInLogFiles

import java.util.*

class Solution {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val sortedLogs: MutableList<Log> = ArrayList<Log>(logs.size)
        for (i in logs.indices) {
            sortedLogs.add(Log(logs[i], i))
        }
        sortedLogs.sort()
        val sortedArray: Array<String> = Array(logs.size) { "" }
        for (i in sortedLogs.indices) {
            sortedArray[i] = sortedLogs[i].toString()
        }
        return sortedArray
    }

    class Log(private val line: String, private val order: Int) : Comparable<Log> {
        private val firstWordIndex: Int = line.indexOfFirst { c -> c == ' ' } + 1
        private val isDigitLog: Boolean = line[firstWordIndex].isDigit()

        override fun compareTo(other: Log): Int {
            if (this.isDigitLog && !other.isDigitLog) {
                return 1
            }
            if (!this.isDigitLog && other.isDigitLog) {
                return -1
            }
            if (this.isDigitLog && other.isDigitLog) {
                return this.order - other.order
            }
            var i = this.firstWordIndex
            var j = other.firstWordIndex
            while (i < this.line.length && j < other.line.length) {
                if (this.line[i] - other.line[j] != 0) {
                    return this.line[i] - other.line[j]
                }
                i++
                j++
            }
            val lengthDiff = (this.line.length - this.firstWordIndex) - (other.line.length - other.firstWordIndex)
            if (lengthDiff != 0) {
                return lengthDiff
            }
            i = 0
            j = 0
            while (i < this.firstWordIndex && j < other.firstWordIndex) {
                if (this.line[i] - other.line[j] != 0) {
                    return this.line[i] - other.line[j]
                }
                i++
                j++
            }
            return this.firstWordIndex - other.firstWordIndex
        }

        override fun toString(): String {
            return line
        }
    }
}

fun main() {
    println("bbc" < "abcd")
}