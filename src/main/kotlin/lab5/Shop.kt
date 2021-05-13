package lab5

import java.util.*

class Shop(possibleProductList: List<Product>) {
    private val products: List<Product> = chooseRandomFromList(possibleProductList)

    init {
        printProducts(products)
    }

    fun isProductPresent(product: Product): Boolean = products.contains(product)
}