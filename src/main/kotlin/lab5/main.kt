package lab5

fun main(){
    val shopManager = ShopManager()
    val husband = Husband(shopManager)
    Wife().formList().let { husband.processProductList(Menu().loop(it)) }
}