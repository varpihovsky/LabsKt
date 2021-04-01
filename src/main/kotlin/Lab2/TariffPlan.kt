package Lab2

import java.io.File
import java.util.*

fun main() {
    Subscriber.load().run {
        println(this)
        topUp()
        println(balance)
        println(this)
    }
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

open class Subscriber(
    val mobilePhone: String,
    var tariffPlanName: String,
    account: Float,
    var tariffPlan: TariffPlan
) {
    var balance: Float = account
        protected set

    fun topUp() {
        balance += 20
    }

    fun topUpOnValue(value: Float) {
        balance += value
    }

    override fun toString(): String =
        "Subscriber(mobilePhone='$mobilePhone', tariffPlanName='$tariffPlanName', tariffPlan=$tariffPlan, balance=$balance)"


    companion object {
        fun load(pathToSubscriber: String = "a1.txt", pathToTariffPlan: String = "a2.txt"): Subscriber {
            Scanner(File(pathToSubscriber)).let {
                return Subscriber(
                    it.getNextLineOrNull() ?: "",
                    it.getNextLineOrNull() ?: "",
                    it.getNextFloatOrNull() ?: 0f,
                    TariffPlan.load(pathToTariffPlan)
                )
            }
        }
    }
}

fun Scanner.getNextLineOrNull(): String? =
    if (hasNextLine()) nextLine() else null


fun Scanner.getNextFloatOrNull(): Float? =
    if (hasNextLine()) nextLine().toFloatOrNull() else null