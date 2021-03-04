package Lab2

import java.io.File
import java.util.*

fun main() {
    val subscriber = Subscriber.load()
    println(subscriber)
    subscriber.topUp()
    println(subscriber.balance)
    //subscriber.balance = 0 Error
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
    private var account: Float,
    var tariffPlan: TariffPlan
) {
    val balance: Float
        get() = account

    fun topUp() {
        account += 20
    }

    fun topUpOnValue(value: Float) {
        account += value
    }

    override fun toString(): String {
        return "Subscriber(mobilePhone=$mobilePhone, tariffPlanName=$tariffPlanName, balance=$balance," +
                " tariffPlan=$tariffPlan"
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