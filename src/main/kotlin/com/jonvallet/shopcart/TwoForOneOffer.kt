package com.jonvallet.shopcart

class TwoForOneOffer(private val item: Item): Offer  {
    override fun getDiscount(items: Map<Item, Int>): Int {
        val quantity = items.getOrDefault(item, 0)
        return if (quantity > 1) {
            (quantity / 2) * item.price
        } else {
            0
        }
    }
}
