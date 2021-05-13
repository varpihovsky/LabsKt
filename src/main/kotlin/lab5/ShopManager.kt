package lab5

class ShopManager {
    private val shops: List<Shop> = formList()

    private fun formList(): List<Shop>{
        println("Total list: ")
        return listOf(Shop(JEWELLERY_PRODUCTS), Shop(FOOD_PRODUCTS), Shop(ELECTRONIC_PRODUCTS))
    }

    fun buyProduct(product: Product): Boolean =
        shops.map { it.isProductPresent(product) }.contains(true)

    companion object {
        val JEWELLERY_PRODUCTS = listOf(
            Product("Diamond", 10000F),
            Product("Gold", 2000F),
            Product("Silver", 1000F),
            Product("Bronze", 500F)
        )

        val FOOD_PRODUCTS = listOf(
            Product("Potato", 40.5F),
            Product("Milk", 80F),
            Product("Bread", 20F),
            Product("Butter", 60.5F),
            Product("Sausage", 72.3F)
        )

        val ELECTRONIC_PRODUCTS = listOf(
            Product("Sony", 100F),
            Product("Samsung", 110F),
            Product("Sharp", 80F),
            Product("Apple", 300F),
            Product("Acer", 105F)
        )
    }
}