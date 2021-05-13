package lab5

import java.util.*

fun <T> chooseRandomFromList(list: List<T>): List<T>{
    val random = Random()
    return list.toMutableList().apply {
        for(i in 0..random.nextInt(size) / 2){
            removeAt(random.nextInt(size))
        }
    }.toList()
}

fun printProducts(list: List<Product>){
    list.forEach { println("${it.name} - ${it.price}") }
}