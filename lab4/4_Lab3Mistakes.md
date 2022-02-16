% Lab 3
% CS2030S
% 17 Feb 2022

# Some mistakes

## Keeping all your fields in `ShopEvent`
```java
// ShopEvent.java
abstract class ShopEvent {
	private Shop shop;
	private Counter counter; // not necessary for every Event!
	private Customer customer;

	// ...
}

class DepartureEvent extends ShopEvent {
	// doesn't involve any counter, since
	// customer is just leaving the shop
}

```

## `@Override`
- remember to use the `@Override` annotation when you override
	- the parent method
	- the interface method

## `private`
- remember to `private` your fields!
	- some non-private fields were in unused classes 🤨
	- juz delete the classes that you're not using
		- less room for mark-deductions!
