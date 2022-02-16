% Lab 4 📦
% CS2030S
% 17 Feb 2022

## `Box<T>`
1. contains a `private final` field of type `T` to store the item
2. has a static method `of` that returns a box with the given object
	- note: since there is a factory method `of` already, keep the constructor `private`
	- also, `Box.of(null)` should just return `null` (don't create a new box instance)

---

## `Box<T>`

3. overrides the `equals` method
4. overrides the `toString` method

# Previously, we had,

---

### Classes ***without*** static constructors
```java
class Box<T> {
	private final T val;

	// constructor
	public Box(T val) {
		this.val = val;
	}
}
```
Initialising the object:
```java
Box<Integer> b = new Box<Integer>(1); // ✅
```

---

### Classes ***with*** static constructors V1
```java
class Box<T> {
	private final T val;

	// constructor
	public Box(T val) {
		this.val = val;
	}

	// we add a factory method here
	public static <T> Box<T> of(T val) {
		return new Box<T>(val);
	}
}
```

---

### Initialising the object:
```java
Box<Integer> b1 = new Box<Integer>(1); // ✅
Box<Integer> b2 = Box.of(1);		   // ✅
```

---

### Classes ***with*** static constructors V2
```java
class Box<T> {
	private final T val;

	// since we have the factory method
	// we can make the constructor private
	private Box(T val) {						
		this.val = val;
	}

	public static <T> Box<T> of(T val) {
		return new Box<T>(val);
	}
}
```

---

### Initialising the object:
```java
// ❌ (since the constructor is now private)
Box<Integer> b1 = new Box<Integer>(1);

// ✅
Box<Integer> b2 = Box.of(1);
```

---

## Why use static constructors? 🧐
If you want to return `null` if the value passed to the constructor of `Box<T>` is `null`, you can't achieve this by using only normal constructors.

## without static constructor
```java
// goal: prevent A from being instantiated with null

public class A<T> {
	private T x;

	// you cannot return null from a constructor 😅
	public A(T x) {
		if (x == null) {
			return null; // ❌ error: incompatible types: 
						 // unexpected return value
		}

		this.x = x;
	}
}
```

## with static constructor
```java
// goal: prevent B from being instantiated with null

public class B<T> {
	private T x;

	// don't let B be instantiated directly
	private B(T x) {
		this.x = x;
	}

	// B can only be instantiated through this
	// factory method
	public static <U> B<U> of(U val) {
		// now you can check and make sure that B
		// cannot be instantiated with null!
		if (val == null) { 
			return null;   
		}

		// (only return a new instance of B if the 
		// input is non-null)
		return new B<U>(val);
	}
}
```

---

### empty box
1. <mark>***only one empty box***</mark>
	- so we want to *cache* or reuse this empty box
	- create a `private final static` named **EMPTY_BOX**

---

### empty box
2. what should the type of **EMPTY_BOX** be?
	- hint: `Box<Anything>` (which *symbol* would represent <mark>Anything</mark>? 🧐)
3. `ofNullable` behaves *almost* exactly like `of`
	- but returns an empty box when the input is `null`

---

## box operations
- Create a generic ***interface*** `BooleanCondition<T>` 
	- with a single abstract `boolean` method `test`

---

## box operations
- Now that you have this interface, you can create classes that ***implement*** `BooleanCondition<T>`
	- each class would have different implementations of the `boolean` method `test`
		1. `DivisibleBy`
		2. `LongerThan`

---

### box operations
- Add a method `filter` to the class `Box<T>` that takes in a `BooleanCondition`
	- this method would return **EMPTY_BOX** if the condition fails, or
	- the original box if the condition passes

---

### transforming a box
- Create an ***interface*** `Transformer<T,U>` 
	- with a single abstract method `transform`
		- *takes in* type T and 
		- *returns* type U

---

### transforming a box
- Now that you have this interface, you can create classes that ***implement*** `Transformer`
	- each class would have different implementations of the method `transform`
		- `LastDigitsOfHashCode`
		- `BoxIt<T>`

---

### transforming a box
- Add a method `map` to the class `Box<T>` that takes in a `Transformer`
	- this method would call the `transform` method of `Transformer`
	- to transform the box into another box of type `Box<U>`

---

### remember PECS
Producer <mark>`extends`</mark>, Consumer <mark>`super`</mark>

---

### more on `Transformer`
```java
class Box<T> {	
	private final T val;

	// ...

	public <U> Box<U> map(
		Transformer<? super T, ? extends U> transformer
		) 
	{
		// ...
	}

	// ...

}
```
- input: Anything super-class of type `T`
- output: Something that is a sub-class of type `U`
