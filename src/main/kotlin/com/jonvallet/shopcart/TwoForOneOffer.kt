package com.jonvallet.shopcart

data class TwoForOneOffer(override val item: Item): Offer  {
    override fun getDiscount(items: Map<Item, Int>): Int {
        val quantity = items.getOrDefault(item, 0)
        return if (quantity > 1) {
            (quantity / 2) * item.price
        } else {
            0
        }
    }
}
