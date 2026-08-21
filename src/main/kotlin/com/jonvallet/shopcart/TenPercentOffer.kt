package com.jonvallet.shopcart

data class TenPercentOffer(override val item: Item) : Offer {
    override fun getDiscount(items: Map<Item, Int>): Int {
        val quantity = items.getOrDefault(item, 0)
        return (quantity * item.price) / 10
    }
}
