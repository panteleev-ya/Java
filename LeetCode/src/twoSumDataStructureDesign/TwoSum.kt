package twoSumDataStructureDesign

class TwoSum() {
    private val map = mutableMapOf<Int, Int>()

    fun add(number: Int) {
        map.merge(number, 1) { a, b -> a + b }
    }

    fun find(value: Int): Boolean {
        for (num in map.keys) {
            if (num + num == value && map.getOrDefault(num, 0) > 1) {
                return true
            } else if (num + num != value && map.contains(value - num)) {
                return true
            }
        }
        return false
    }
}