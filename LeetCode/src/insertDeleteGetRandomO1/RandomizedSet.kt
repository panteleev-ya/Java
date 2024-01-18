package insertDeleteGetRandomO1

import kotlin.random.Random

class RandomizedSet {
    private val elementsMap = mutableMapOf<Int, Int>()
    private val existingElements = mutableListOf<Int>()
    private val generator = Random(42)

    fun insert(`val`: Int): Boolean {
        return if (elementsMap.containsKey(`val`)) {
            false
        } else {
            existingElements.add(`val`)
            elementsMap[`val`] = existingElements.lastIndex
            true
        }
    }

    fun remove(`val`: Int): Boolean {
        val index = elementsMap[`val`] ?: return false
        if (index != existingElements.lastIndex) {
            // if value to be removed is at middle of list,
            // shift lastitem to there so that we can just remove lastitem in O(1)
            existingElements[index] = existingElements.last()
            elementsMap[existingElements[index]] = index
        }
        elementsMap.remove(`val`)
        existingElements.removeLast()
        return true
    }

    fun getRandom(): Int {
        return existingElements[generator.nextInt(existingElements.size)]
    }
}

fun main() {
    val set = RandomizedSet()
    set.insert(10)
    println(set.getRandom())
    set.remove(10)
    set.insert(11)
    set.insert(12)
    println(set.getRandom())
}
