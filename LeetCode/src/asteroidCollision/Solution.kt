package asteroidCollision

import java.util.*
import kotlin.math.abs

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        for (asteroid in asteroids) {
            if (stack.isEmpty()) {
                stack.add(asteroid)
                continue
            }
            var lastAsteroid = stack.peek()
            while (true) {
                if (!(lastAsteroid > 0 && asteroid < 0)) {
                    stack.add(asteroid)
                    break
                }
                val sizeLast = abs(lastAsteroid)
                val sizeCurrent = abs(asteroid)
                if (sizeCurrent < sizeLast) {
                    break
                }
                stack.pop()
                if (sizeCurrent == sizeLast) {
                    break
                }
                if (stack.isEmpty()) {
                    stack.add(asteroid)
                    break
                }
                lastAsteroid = stack.peek()
            }
        }
        return stack.toIntArray()
    }
}
