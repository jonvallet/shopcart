# Shopping Cart 

## Prerequisites

* **Java Development Kit (JDK) 21:** Ensure you have JDK 21 installed and configured correctly. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk21-archive-downloads.html) or use a distribution like Adoptium Temurin or SDKMAN!.


## Building and running tests

Builds the project
```shell
./gradlew build
```
If you want to see a summary of the tests
```shell
./gradlew test -i
```

### Assumptions
* You can have multiple Items with the same name but different price. This can be changed if required
* ShoppingCart is not thread safe. 
* All prices are store as pences in an Integer value.
* Only one offer per item/price can be applied.
* The price of an item has to be greater than zero.