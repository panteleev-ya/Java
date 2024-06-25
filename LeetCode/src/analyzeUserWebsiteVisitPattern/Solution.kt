package analyzeUserWebsiteVisitPattern


class Solution {
    fun mostVisitedPattern(username: Array<String>, timestamp: IntArray, website: Array<String>): List<String> {
        val combinations = mutableMapOf<String, Int>()
        var maxFreq = 0
        var result = ""

        // Функция для генерации комбинаций сайтов и их частот
        fun combine(userSites: List<String>) {
            val uniqueCombinations = mutableSetOf<String>()
            val n = userSites.size
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    for (k in j + 1 until n) {
                        val permutation = "${userSites[i]},${userSites[j]},${userSites[k]}"
                        if (permutation !in uniqueCombinations) {
                            uniqueCombinations.add(permutation)
                            combinations[permutation] = (combinations[permutation] ?: 0) + 1

                            if (maxFreq < combinations[permutation]!!) {
                                maxFreq = combinations[permutation]!!
                                result = permutation
                            } else if (maxFreq == combinations[permutation]!! && permutation < result) {
                                result = permutation
                            }
                        }
                    }
                }
            }
        }

        // Собираем посещения пользователей
        val users = mutableMapOf<String, MutableList<Pair<Int, String>>>()
        for (i in username.indices) {
            val user = username[i]
            val time = timestamp[i]
            val web = website[i]

            users.computeIfAbsent(user) { mutableListOf() }.add(time to web)
        }

        // Сортируем посещения по временной метке для каждого пользователя
        val sortedUserVisits = users.mapValues { entry ->
            entry.value.sortedBy { it.first }.map { it.second }
        }

        // Генерация комбинаций для каждого пользователя
        for (entry in sortedUserVisits) {
            combine(entry.value)
        }

        return result.split(',')
    }
}

fun main() {
    println(
        Solution().mostVisitedPattern(
            arrayOf("zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"),
            intArrayOf(436_363_475, 710_406_388, 386_655_081, 797_150_921),
            arrayOf("wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht")
        )
    )
}