package Lab2

import java.io.File
import java.util.*

fun main() {
    val subscriber = Subscriber.load()
    println(subscriber)
    subscriber.topUp()
    println(subscriber)
}

data class TariffPlan(val smsCost: Float, val phoneCost: Float, val phoneToOthersCost: Float) {
    companion object {
        fun load(path: String): TariffPlan =
            Scanner(File(path)).let {
                return@let TariffPlan(
                    it.getNextFloatOrNull() ?: 0f,
                    it.getNextFloatOrNull() ?: 0f,
                    it.getNextFloatOrNull() ?: 0f
                )
            }
    }
}

data class Subscriber(
    val mobilePhone: String,
    var tariffPlanName: String,
    private var balance: Float,
    var tariffPlan: TariffPlan
) {
    fun getBalance() = balance

    fun topUp() {
        balance += 20
    }

    fun topUpOnValue(value: Float) {
        balance += value
    }

    companion object {
        fun load(pathToSubscriber: String = "a1.txt", pathToTariffPlan: String = "a2.txt"): Subscriber {
            val scanner = Scanner(File(pathToSubscriber))
            return Subscriber(
                scanner.getNextLineOrNull() ?: "",
                scanner.getNextLineOrNull() ?: "",
                scanner.getNextFloatOrNull() ?: 0f,
                TariffPlan.load(pathToTariffPlan)
            )
        }
    }
}

fun Scanner.getNextLineOrNull(): String? = this.let {
    if (it.hasNextLine()) {
        it.nextLine()
    } else {
        null
    }
}

fun Scanner.getNextFloatOrNull(): Float? = this.let {
    if (it.hasNextLine()) {
        it.nextLine().toFloatOrNull()
    } else {
        null
    }
}