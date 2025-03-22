package com.jonvallet.shopcart

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class ShoppingCartTest {

	@Test
	fun shouldBeAbleToAddItem() {
		val bread = Item("bread", 100)
		val expectedShoppingCart = mapOf(bread to 1)
		val actualShoppingCart = ShoppingCart().add(bread).getShoppingCart()

		assertEquals(expectedShoppingCart, actualShoppingCart)
	}

}
