package assignCookies

class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var greedPointer = 0
        var sizePointer = 0
        var countContent = 0
        while (sizePointer < s.size && greedPointer < g.size) {
            if (g[greedPointer] <= s[sizePointer]) {
                greedPointer++
                countContent++
            }
            sizePointer++
        }
        return countContent
    }
}