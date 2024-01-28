package numberOfSubmatricesThatSumToTarget

class Solution {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val n = matrix.size
        val m = matrix[0].size
        var result = 0

        // traverse upper boundary
        for (top in 0 until n) {
            // for each upper boundary, we have a prefix sum array

            val sum = IntArray(m)

            // traverse lower boundary
            for (bottom in top until n) {
                // count the prefix sum for each column

                for (col in 0 until m) {
                    sum[col] += matrix[bottom][col]
                }

                // traverse left and right boundary
                for (left in 0 until m) {
                    var cnt = 0
                    for (right in left until m) {
                        cnt += sum[right]
                        if (cnt == target) {
                            result++
                        }
                    }
                }
            }
        }
        return result
    }
}