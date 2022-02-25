% Lab 6 ❓
% CS2030S
% 10 March 2022

## JavaDocs
- For `Lazy.java`, write JavaDocs for all the methods
	- [guide to JavaDocs](https://nus-cs2030s.github.io/2021-s2/javadoc.html)
- For everything else, JavaDocs is optional but encouraged.

## wad is lazy?
> Your task is to write an ***immutable*** Lazy class to support the operations involving lazy values.

> A lazy value is ***not evaluated during creation***, but only until the value is needed. Moreover, the ***first time this value is computed, a cached copy is stored.*** 

## wad is lazy? (continued.)
> This allows subsequent accesses to this same value to be retrieved directly, rather than computing it all over again.

## example
```java
// behaviour for function

Producer<String> s = () -> "hello";
Lazy<String> hello = Lazy.of(s);
System.out.println(hello); 		// prints "?" 
				// (because you have not evaluated it yet)
hello.get(); 					
System.out.println(); 			// prints "hello" 
				// (because you've already evaluated it)
```

```java
// behaviour for value

Lazy<Integer> eight = Lazy.of(8);
System.out.println(eight); 		// prints "8" 
				// (because, even though you haven't called get(),
				// there is no need to compute/calculate anything,
				// since 8 is already a value!
```

## Your Todos for Lab 6 ✍️
- create a generic class `Lazy<T>`
	- has 2 `static` *factory* methods:
		- `of(T v)`
		- `of(Producer<T> s)`
	- has x *instance* methods
		- `get()`
		- `map(...)`
		- `flatMap(...)`
		- `filter(...)`
		- `combine(...)` 🖇
	- overrides
		- `toString()`
		- `equals(...)`
- create a generic class `LazyList<T>`

# `Lazy<T>`

## `Lazy<T>` factory methods
- `of(Producer<T> s)`
	- imagine we have a *really intensive* piece of code that takes really long to run
	- we want to save the result somewhere, (so that we won't have to run it twice)
	- here, `Producer<T>#produce()` represents this form of computation
		- we want to only call `produce()` 
			- *only once*
			- *only when needed*

- `of(T v)`)
	- takes in a value that is already computed! 
		- no calculations needed

## `get()`
- if the value inside `Lazy<T>` has already been computed
	- simply return the value
- if not,
	- get the `Producer<T>` to `produce()` the value
	- save it
	- then return the value
- note that we want `get()` to be **lazy**, which means
	- we only perform the calculation *when needed*
		- only when someone calls `get()`
	- meaning we *do not* perform the calculation when the `Lazy<T>` instance is instantiated

## `map` and `flatMap`
- returns a `Lazy<T>` instance
- recall that they take in a `Transformer` that basically does some conversion
- note that this conversion should also be *lazy*
	- meaning it should not be done until `get()` is called on the `Lazy<T>` instance returned

## `map` and `flatMap`

```java
// example

Producer<String> s = () -> "123456";
Lazy<String> lazy = Lazy.of(s);

// takes in a String and returns another String that
// only contains the first character!
Transformer<String, String> substr = str -> {
   System.out.println("substring");

   return str.substring(0, 1);
}

Lazy<String> lazySubString = lazy.map(substr)

System.out.println(lazySubString); // prints "?"

lazy.get(); 					   // prints "substring"
System.out.println(lazySubString); // prints "1"

lazy.get();						   // nothing is printed this time!
								   // (since the substr function
								   //  is no longer called!)
```

## `filter`
- returns a `Lazy<Boolean>` instance
- note: `filter` is also *lazy*
```java
// example

Lazy<Integer> fifty = Lazy.of(50)
Lazy<Boolean> even = fifty.filter(i -> i % 2 == 0)
System.out.println(even) // prints "?"
even.get()
System.out.println(even) // prints "true"
```

# Interlude: Combiner

## `Combiner<S, T, R>`
- is an `interface` that is already provided to you
- contains a single method called `combine`, which
	- basically takes in **two** values
		- the first is of type `S`
		- the other is of type `T`
	- returns **one** value
		- of type `R`

# back to our `Lazy<T>` class

## `combine`
- takes in 2 things
	- another `Lazy` instance
	- an instance of `Combiner`
- basically, calls the `combine()` method of the `Combiner`, which
	- combines the value in this `Lazy` instance with the other `Lazy` instance and
	- returns an instance of `Lazy` that containing this combined value

## `combine` (continued.)
- note that this method is *lazy*
	- meaning that this combining is *not actually done* until `get()` is called on the `Lazy` instance that is returned by this function!
	- same idea as `map`/`flatMap`

## `equals`
- basically the same as normal `equals` methods you've seen before
	- is an `EAGER` method ❗️ (not lazy like the other methods)
	- returns you a `boolean`
- has the same effect as `get()` when called:
	- triggers the computation of the value (if `get` has not been called yet)


# `LazyList<T>`

## what to do
- the main problem with `EagerList<T>` is that at instantiation, it calls `transform` on *everything*
	- can we use our `Lazy<T>` class, and the `map` function inside it to *defer* this?

## hint
> Hint: you only need to make minimal changes!

# Good luck! 😃









