package com.jonvallet.shopcart

class ShoppingCart {
    private val items = mutableMapOf<Item, Int>()

    fun getShoppingCart(): Map<Item, Int> {
        return items.toMap()
    }

    fun add(item: Item): ShoppingCart {
        val previousValue = items.getOrDefault(item, 0)
        items[item] = previousValue + 1
        return this
    }

    fun remove(item: Item): ShoppingCart {
        val previousValue = items.getOrDefault(item, 0)
        if(previousValue > 0) {
            items[item] = previousValue - 1
        }
        return this
    }

    fun getTotal(): Int {
        return items.map { it.key.price * it.value }.sum()
    }
}

