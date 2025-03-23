package com.jonvallet.shopcart

/**
 *
 * @property name name of the item
 * @property price of the item in pences
 *
 */
data class Item(val name: String, val price: Int) {
    init {
        require(price > 0) { "Price must be positive" }
    }
}
