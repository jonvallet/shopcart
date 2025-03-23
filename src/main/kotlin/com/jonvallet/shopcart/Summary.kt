package com.jonvallet.shopcart

data class Summary(val items: Map<Item, Int>, val totalPrice: Int, val totalDiscount: Int) {
    companion object {
        fun fromShoppingCart(shoppingCart: ShoppingCart): Summary {
            return Summary(
                shoppingCart.getShoppingCart(),
                shoppingCart.getTotal(),
                shoppingCart.getTotalDiscounts()
            )
        }
    }

    override fun toString(): String {

        val stringBuilder = StringBuilder()
        stringBuilder.append("Items: \n")
        stringBuilder.append("--------------------------- \n")
        items.forEach { (item, quantity) -> stringBuilder.append("${item.name} price = ${"£%.2f".format(item.price/ 100.0)} quantity = ${quantity}\n") }
        stringBuilder.append("--------------------------- \n")
        stringBuilder.append("Total Price = ${"£%.2f".format(totalPrice/ 100.0)} \n")
        stringBuilder.append("Total Discounts = ${"£%.2f".format(totalDiscount/ 100.0)} \n")
        stringBuilder.append("--------------------------- \n")
        stringBuilder.append("Final Price = ${"£%.2f".format((totalPrice - totalDiscount)/ 100.0)} \n")

        return stringBuilder.toString()
    }

}
