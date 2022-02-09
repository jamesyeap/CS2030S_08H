% Lab 2 Recap
% CS2030S
% 10 Feb 2022

## `String.format`

```java
class A {
	@Override
	public String toString() {
		return "Hi I'm A";
	}
}

A a = new A()
String.format("A says hi: %s", A); // replaces %s with A.toString()

// A says hi: Hi I'm A
```

## General Feedback for Lab 1
- Cannot compile 😐
	- ***0 marks*** if your code cannot compile
- Information Hiding
	- deduct 1 mark for each field not declared `private`
- Encapsulation
	- missing `Shop`, `Counter` or `Customer` classes
	- deduct 1 mark for each missing class 
- Tell, Don't Ask
	- finding available counters should be done by the `Shop`
		- not directly inside `ArrivalEvent`
	- customer should be responsible for its own String representation
	- counter should be responsible for its own String representation

## Use more obvious names
```java
class Counter {
	// ...
	private boolean available;

	public boolean isAvailable() {
		return this.available;
	}
}
```
```java
Counter c1 = new Counter();
if (c1.isAvailable()) { ✅
	// ...
}
```

```java
Counter c1 = new Counter();
if (c1.getAvailability()) { 🧐
	// ...
}
```
