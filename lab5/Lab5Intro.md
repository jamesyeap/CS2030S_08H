% Lab 5 ❓
% CS2030S
% 3 March 2022

## Java `package`
```java
// file is in: "lab5-xxx/cs2030s/fp/SomeFile.java" ℹ️ MUST BE INSIDE THIS DIRECTORY

package cs2030s.fp; // ℹ️ MUST MATCH THE DIRECTORY THAT THE FILE IS IN

class SomeFile {
	// ...
}
```

## Todos for Lab 5
- make an interface `Producer<T>`
- make an abstract class `Maybe<T>`, which has:
	- 2 **nested**, `static` concrete classes
		- `None`
		- `Some<T>`

	- 3 `static` **factory methods**
		- `none()`
		- `some(T t)`
		- `of`

## Todos for Lab 5 (continued)
- (continued) make an abstract class `Maybe<T>`, which has:
	- 6 `protected`, `abstract` instance (NOT `static`) methods
		- `get`
		- `filter`		
		- `map`			
		- `flatMap`
		- `orElse`
		- `orElseGet`

## Todos for Lab 5 (continued)
- use your `Maybe<T>` class in `Lab5.java` 
	- don't forget to do this part!

## `Producer<T>`
- An interface with only one method `produce`, which
	- takes in no parameter
	- returns a value of type `T`

## `Maybe<T>`
- An abstract class that contains 2 nested classes that `extends` from it
	- `None`
	- `Some<T>`
- When implementing these two classes, remember to `@Override` *all* the abstract methods inside `Maybe<T>`!
	- standard stuff

## `None`
- a concrete *nested* class inside `Maybe<T>`
- Like the `EMPTY_BOX` in Lab 4

## `Some<T>`
- a concrete *nested* class inside `Maybe<T>`

## `none()`
- a `static` factory method of `Maybe<T>`
- returns the same instance of `None` every time (
- like `empty()` in Lab 4

## `some(T val)`
- a `static` factory method of `Maybe<T>`
- returns an instance of `Some<T>`

## `of(T val)`
- a `static` factory method of `Maybe<T>`	
- if the input is `null`
	- returns a `None` instance
- else
	- returns a `Some` instance with the given value inside

## `get()`
- a `protected` `abstract` instance method inside `Maybe<T>`
- returns the value that is inside the `Maybe` instance
- if the instance is of type `Some<T>`
	- this method should return the value inside
- if the instance is of type `None`
	- this method should throw a `NoSuchElementException` 💥


## `filter(BooleanCondition<...> cond)`
- a `protected` `abstract` instance method inside `Maybe<T>`
- same idea as in Lab 4
- if the instance is of type `Some<T>`
	- returns `None` if the condition fails
	- returns itself if the condition passes
- if the instance is of type `None`
	- returns an instance of `None`

## `map(Transformer<... , ...> transformer)`
- a `protected` `abstract` instance method inside `Maybe<T>`
- same idea as in Lab 4
- if the instance is of type `Some<T>`
	- takes in a `Transformer` that produces some object 
	- **AND** wraps what `Transformer` returns in a `Maybe` object before returning it
- if the instance is of type `None`
	- returns an instance of `None`

## `flatMap(Transformer<... , Maybe<...>> transformer)`
- a `protected` `abstract` instance method inside `Maybe<T>`
- takes in a `Transformer` that produces a `Maybe` object 
- **DOES NOT** wrap it in a `Maybe` object (if not, we will be wrapping a `Maybe` inside another `Maybe`) 
- same behaviour as `map` (except for the above difference)

## `orElse(U defaultValue)`
- a `protected` `abstract` instance method inside `Maybe<T>`
- takes in some default value, say `defaultValue`
- if the instance is of type `Some<T>`
	- will just return the actual value stored inside it
- if the instance is of type `None`
	- returns `defaultValue`

## `orElseGet(Producer<...> producer)`
- a `protected` `abstract` instance method inside `Maybe<T>`
- takes in a `Producer`
- if the instance is of type `Some<T>`
	- will just return the actual value stored inside it
- if the instance is of type `None`
	- returns calls the `Producer` to produce a value, and returns this value

## Rewrite `Lab5.java` with the classes that you've created!
- refer to `Question.md` for more details
