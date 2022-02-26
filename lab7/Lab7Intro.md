% Lab 7 ♾
% CS2030S
% TBD March 2022

## JavaDocs
- For `InfiniteList.java`, write JavaDocs for all the methods
	- [guide to JavaDocs](https://nus-cs2030s.github.io/2021-s2/javadoc.html)
- For everything else, JavaDocs is optional but encouraged.

# Infinite List ♾

# Level 1 - setting up preliminaries

## 2 fields
- `InfiniteList` has only 2 *instance* fields,
	- `Lazy<Maybe<T>>` head
	- `Lazy<InfiniteList<T>>` value

## 3 factory methods
- `generate()`
	- takes in a `Producer<T>`
- `iterate()`
	- takes in a `T seed` and `Transformer<T,T>`
- `empty()`
	- returns an *empty* `InfiniteList`
		- hint: may want to create a nested subclass of `InfiniteList` that represents an empty `InfiniteList`

## whats the difference?*
- `generate()` returns a list that produces the next value that 
	- is ***independent*** of the previous one!
- `iterate()` returns a list that produces the next value that 
	- is ***dependent*** on the previous one!

## Level 2 - deja vu
- `map()`
	- takes in a `Transformer<? super T, ? extends U>`
	- does what it says: converts each element in the `InfiniteList` 
		- as specified in the `transform` method of the `Transformer` that is passed in

## Level 3 - deja vu
- `filter()`
	- takes in a `BooleanCondition<? super T>`
	- values in the `InfiniteList` that don't pass the test will be eliminated
		- but will still remain inside the list!
		- *sounds familar?* - an instance of `None`?

## Level 4 - new stuff
- `isEmpty()`
	- checks if this is an instance of `EmptyList`
- `limit()`
	- takes in a `long` value `n`, and cuts down the length of `InfiniteList` from infinite to size `n`
- `toList()`
	- is a *terminal* method that converts the `InfiniteList<T>` to a `List<T>`

## Level 5 - new stuff
- `takeWhile()`
	- takes in a `BooleanCondition<? super T> cond`
	- if `bc.test()` on the current element is `false`, *terminate* the `InfiniteList`

## Level 6 - terminal operations
- `count()`
	- counts the number of elements in the `InfiniteList`

## Level 6 - terminal operations
- `reduce()`
	- takes in a `U seed` and `Combiner<? super U, ? super T, ? extends U>`
	- takes the first element of the `InfiniteList`; call it `elem`, then
		- runs `combine(seed, elem)`, which returns a value `combinedElem`
		- then, runs `combine(combinedElem, nextElem)`
			- where `nextElem` is the subsequent element in the `InfiniteList`
		- this continues on until the *end* of the `InfiniteList` has been reached

## Some tips
- use recursion
- make use of the given abstractions in `Maybe` or `Lazy` classes!
- start early

## Todos for `InfiniteList`
- 2 fields
	- `Lazy<Maybe<T>> head`
	- `Lazy<InfiniteList<T>> value`
- 3 ways to create an infinite list
	- `generate()`
	- `iterate()`
	- `empty()`
- `map()`
- `filter()`
- `isEmpty()`
- `empty()`
- `limit()`

## Todos for `InfiniteList`
- `toList()`
- `takeWhile()`
- `count()`
- `reduce()`