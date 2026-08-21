package com.jonvallet.shopcart

interface Offer {
    val item: Item
    fun getDiscount(items: Map<Item, Int>): Int
}