package Lab3

import Lab2.Subscriber
import Lab2.TariffPlan

fun main() {
    SubscriberExtended.load().run {
        println(this)
        topUp()
        printAvailableCallsAndSMS()
        switchTariff("a5.txt")
        println(this)
        printAvailableCallsAndSMS()
    }
}

class SubscriberExtended(
    mobilePhone: String,
    tariffPlanName: String,
    account: Float,
    tariffPlan: TariffPlan
) : Subscriber(mobilePhone, tariffPlanName, account, tariffPlan) {
    constructor(subscriber: Subscriber) : this(
        subscriber.mobilePhone,
        subscriber.tariffPlanName,
        subscriber.balance,
        subscriber.tariffPlan
    )

    fun switchTariff(pathToTariffPlan: String) {
        if (balance < 10) {
            throw RuntimeException("Balance is too small to switch tariff")
        }

        Subscriber.load(pathToTariffPlan).let {
            tariffPlan = it.tariffPlan
            tariffPlanName = it.tariffPlanName
        }

        balance -= 10
    }

    fun printAvailableCallsAndSMS() {
        println(
            "${balance / tariffPlan.phoneCost} - calls inside network\n${balance / tariffPlan.phoneToOthersCost}" +
                    " - calls outside network\n${balance / tariffPlan.smsCost} - available SMS"
        )
    }

    companion object {
        fun load(pathToSubscriber: String = "a1.txt", pathToTariffPlan: String = "a2.txt"): SubscriberExtended {
            return SubscriberExtended(Subscriber.load(pathToSubscriber, pathToTariffPlan))
        }
    }
}