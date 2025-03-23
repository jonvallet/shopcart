package com.jonvallet.shopcart

class ShoppingCart() {
    constructor(offers: Set<Offer>) : this() {
        this.offers.addAll(offers)
    }

    private val items = mutableMapOf<Item, Int>()
    private val offers = mutableSetOf<Offer>()

    fun getShoppingCart(): Map<Item, Int> {
        return items.toMap()
    }

    fun getOffers(): Set<Offer> {
        return offers.toSet()
    }

    fun add(item: Item): ShoppingCart {
        val previousValue = items.getOrDefault(item, 0)
        items[item] = previousValue + 1
        return this
    }

    fun remove(item: Item): ShoppingCart {
        val previousValue = items.getOrDefault(item, 0)
        if (previousValue > 0) {
            items[item] = previousValue - 1
        }
        return this
    }

    fun getTotal(): Int {
        return items.map { it.key.price * it.value }.sum()
    }

    fun getTotalDiscounts(): Int {
        val totalOffersDiscounts = this.offers.sumOf { it.getDiscount(items) }
        return totalOffersDiscounts
    }
}

