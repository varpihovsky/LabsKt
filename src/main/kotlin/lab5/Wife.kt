package lab5

class Wife {
    fun formList(): List<Product>{
        val requestProductList = mutableListOf<Product>()
        requestProductList.addAll(chooseRandomFromList(ShopManager.ELECTRONIC_PRODUCTS))
        requestProductList.addAll(chooseRandomFromList(ShopManager.FOOD_PRODUCTS))
        requestProductList.addAll(chooseRandomFromList(ShopManager.JEWELLERY_PRODUCTS))

        println()
        println("Requested products: ")
        printProducts(requestProductList)

        return requestProductList
    }

}