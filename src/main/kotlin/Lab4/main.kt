package Lab4

import Lab4.Random.getRandomNumber
import kotlin.random.Random

fun main() {
    doPart1()
    println()
    doPart2()
}

private fun doPart1(){
    val movablePoint = MovablePoint(1f, 1f, 0f, 0f)
    do {
        movablePoint.move()
        println(movablePoint)
        movablePoint.xSpeed += 1
        movablePoint.ySpeed += 1
    } while (movablePoint.x <= 50f || movablePoint.y <= 50f)
}

private fun doPart2(){
    val movablePoint = MovablePoint(
        getRandomNumber(-10, 10),
        getRandomNumber(-10, 10),
        getRandomNumber(10, 35),
        getRandomNumber(10, 35)
    )

    repeat(10){
        println(movablePoint)
        movablePoint.move()
        movablePoint.xSpeed += getRandomNumber(-3, 3)
        movablePoint.ySpeed += getRandomNumber(-3, 3)
    }
}

object Random {
    private var seed = System.currentTimeMillis()

    fun getRandomNumber(from: Int, to: Int): Float {
        seed += 100
        val random = Random(seed)
        return random.nextDouble(from.toDouble(), to.toDouble()).toFloat()
    }
}