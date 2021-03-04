package Lab1

fun main(args: Array<String>) {
    val subscriber = Subscriber("06833344411", "Some example tariff")
    val subscriber2 = Subscriber("09899988877", "Some example tariff 2")
    val subscriber3 = Subscriber()
    println(subscriber)
    println(subscriber2)
    println(subscriber3)
}

data class Subscriber(var mobilePhone: String, var tariff: String){
    constructor() : this("000", "tariff00")
}