package lab5


class Husband(private val shopManager: ShopManager) {
    fun processProductList(products: List<Product>) {
        products.mapNotNull { if(shopManager.buyProduct(it)) it else null }.let {
            println()
            println("Bought: ")
            printProducts(it)
            println("Total price: ${it.map { it.price }.sum()}")
        }
    }
}