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

	@Test
	fun shouldBeAbleToAddSameItemTwice() {
		val bread = Item("bread", 100)
		val expectedShoppingCart = mapOf(bread to 2)
		val actualShoppingCart = ShoppingCart().add(bread).add(bread).getShoppingCart()

		assertEquals(expectedShoppingCart, actualShoppingCart)
	}

	@Test
	fun shouldBeAbleToRemoveAnItem() {
		val bread = Item("bread", 100)
		val expectedShoppingCart = mapOf(bread to 0)
		val actualShoppingCart = ShoppingCart().add(bread).remove(bread).getShoppingCart()

		assertEquals(expectedShoppingCart, actualShoppingCart)
	}

	@Test
	fun shouldBeAbleToCalculateTotalCost() {
		val bread = Item("bread", 100)
		val expectedValue = 200
		val shoppingCart = ShoppingCart().add(bread).add(bread)
		assertEquals(expectedValue, shoppingCart.getTotal())
	}

	@Test
	fun shouldBeAbleToCalculateTotalCostForMultipleItems() {
		val bread = Item("bread", 100)
		val eggs = Item("eggs", 10000)
		val expectedValue = 10100
		val shoppingCart = ShoppingCart().add(bread).add(eggs)
		assertEquals(expectedValue, shoppingCart.getTotal())
	}
}
