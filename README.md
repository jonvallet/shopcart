# Shopping Cart 

## Prerequisites

* **Java Development Kit (JDK) 25:** Ensure you have JDK 25 installed and configured correctly. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk25-archive-downloads.html) or use a distribution like Adoptium Temurin or SDKMAN!.


## Building and running tests

Builds the project
```shell
./gradlew build
```

### Assumptions
* You can have multiple Items with the same name but different price. This can be changed if required
* ShoppingCart is not thread safe.
* All prices are store as pences in an Integer value.
* Multiple offers can be configured for the same item, but only the best (largest discount) offer per item is applied.
* The price of an item has to be greater than zero.

## Domain overview

* `ShoppingCart.getTotal()` returns the net price (subtotal minus applied discounts).
* `ShoppingCart.getSubtotal()` returns the gross price of the items, before any discounts.
* `ShoppingCart.getTotalDiscounts()` returns the sum of the best offer's discount for each item that has an offer.
* `Summary` (built via `Summary.fromShoppingCart`) provides an itemised receipt with the subtotal, total discounts and final price.