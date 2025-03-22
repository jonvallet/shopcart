package com.jonvallet.shopcart

class ShoppingCart {
    private val items = mutableMapOf<Item, Int>()

    fun add(item: Item): ShoppingCart {
        val previousValue = items.getOrDefault(item, 0)
        items[item] = previousValue + 1
        return this
    }

    fun getShoppingCart(): Map<Item, Int> {
        return items.toMap()
    }
}

