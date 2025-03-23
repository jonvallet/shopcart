package com.jonvallet.shopcart

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

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

	@ParameterizedTest
	@MethodSource("provideItems")
	fun shouldBeAbleToApplyOffers(items: List<Item>, offers: Set<Offer>, expected: Int) {
		val shoppingCart = ShoppingCart(offers)
		items.forEach { shoppingCart.add(it) }
		assertEquals(expected, shoppingCart.getTotalDiscounts())
	}

	companion object {
		@JvmStatic
		fun provideItems(): Stream<Arguments> {
			val bread = Item("bread", 100)
			val eggs = Item("eggs", 10000)
			return Stream.of(
				Arguments.of(listOf(bread, bread), setOf(TwoForOneOffer(bread)), 100),
				Arguments.of(listOf(bread), setOf(TwoForOneOffer(bread)), 0),
				Arguments.of(listOf(bread, bread, bread), setOf(TwoForOneOffer(bread)), 100),
				Arguments.of(listOf(bread, bread, bread, bread), setOf(TwoForOneOffer(bread)), 200),
				Arguments.of(listOf(bread, bread, eggs, eggs), setOf(TwoForOneOffer(bread)), 100),
				Arguments.of(listOf(bread, bread, eggs, eggs), setOf(TwoForOneOffer(bread), TwoForOneOffer(eggs)), 10100),
			)
		}
	}

}
