package lab5

import java.util.*

class Menu {
    fun  loop(list: List<Product>): List<Product>{
        val resultList = list.toMutableList()
        val scanner = Scanner(System.`in`)
        while (true){
            println("Products: ")
            resultList.forEachIndexed { i: Int, product: Product -> println("$i - ${product.name}, ${product.price}") }
            println("${resultList.size + 1} - exit")
            println("Input command: ")

            try {
                val input = scanner.nextLine().toInt()

                if(input == resultList.size + 1){
                    return resultList
                }
                if(input < 0 || input > resultList.size){
                    println("Wrong command!")
                }

                resultList.removeAt(input)

                println("Product removed")
            } catch (e: Exception){
                println("Wrong command!")
            }
        }
    }
}