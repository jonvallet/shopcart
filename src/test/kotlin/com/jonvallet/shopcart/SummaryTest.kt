package com.jonvallet.shopcart

import com.jonvallet.shopcart.Summary.Companion.fromShoppingCart
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SummaryTest {

    @Test
    fun shouldCalculateSummary() {
        val bread = Item("bread", 100)
        val eggs = Item("eggs", 10000)
        val offers = setOf(TwoForOneOffer(bread))

        val shoppingCart = ShoppingCart((offers))
            .add(bread)
            .add(bread)
            .add(bread)
            .add(eggs)
            .add(eggs)

        val expectedValue = Summary(items = mapOf(bread to 3, eggs to 2), totalPrice = 20300, totalDiscount = 100)
        val actualValue = fromShoppingCart(shoppingCart)
        assertEquals(expectedValue, actualValue)
        println(actualValue)
    }
}