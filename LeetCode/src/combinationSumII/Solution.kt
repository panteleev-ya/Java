package combinationSumII

class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val combinations: MutableList<List<Int>> = mutableListOf()
        backtrack(candidates, combinations, mutableListOf(), target, 0)
        return combinations
    }

    private fun backtrack(
        candidates: IntArray,
        combinations: MutableList<List<Int>>,
        currentCombination: MutableList<Int>,
        target: Int,
        index: Int
    ) {
        if (target < 0) {
            return
        }
        if (target == 0) {
            combinations.add(ArrayList(currentCombination))
            return
        }
        var i = index
        while (i < candidates.size && target >= candidates[i]) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                i++
                continue
            }
            currentCombination.add(candidates[i])
            backtrack(candidates, combinations, currentCombination, target - candidates[i], i + 1)
            currentCombination.removeAt(currentCombination.size - 1)
            i++
        }
    }
}

fun main() {
    println(Solution().combinationSum2(intArrayOf(1, 1, 2, 5, 6, 7, 10), 8))
}