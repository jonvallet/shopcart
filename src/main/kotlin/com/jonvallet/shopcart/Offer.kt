package com.jonvallet.shopcart

interface Offer {
    fun getDiscount(items: Map<Item, Int>): Int
}