% Factory Method 🏭
% CS2030S
% 17 Feb 2022

## What is a Factory Method?
tldr: basically a method that returns you an instance of an object.

## Try writing a class `A` that does the following
```
jshell> new A()
|  Error:
|  A() has private access in A
|  new A()
|  ^-----^
jshell> A.construct()
$4 ==> A@26be92ad
jshell> A.construct()
$5 ==> A@224edc67
```

## Task 1 Solution
```java
class A {
  private A() {
    // empty constructor
  }

  // factory method
  public static A construct() {
    // creates a new instance of A and
    // returns it to the caller
    return new A(); 
  }
}

```

## Now, change the behaviour of class `A` so that it always returns the ***same instance.***
```
jshell> A.construct()
$4 ==> A@26be92ad      // <---
jshell> A.construct()
$4 ==> A@26be92ad      // <--- same instance!
```

## Task 2 Solution
```java
class A {
  // constructs a single instance of A and stores it 
  // as a CLASS field
  private static A a = new A();

  private A() {
    // empty constructor
  }

  // factory method
  public static A construct() {
    // returns the same instance of A!
    return a;
  }
}
```

## That was a *Singleton*
> Singleton is a creational design pattern that lets you ensure that a class ***has only one instance*** ...

source: [refactoring.guru](https://refactoring.guru/design-patterns/singleton/java/example)

## Caching
- change A so that the factory method takes in an `int` as parameter.
  - When the argument is 0, the same instance is always returned. 
  - When the argument is non-zero, a new instance is always created.

```
jshell> A.construct(0)
$4 ==> A@26be92ad      // <---
jshell> A.construct(0)
$4 ==> A@26be92ad      // <--- returns the same instance when 0 is used as a param
jshell> A.construct(1)
$5 ==> A@224edc67      // <---
jshell> A.construct(1)
$4 ==> A@4b9e13df      // <--- creates a new instance if param != 0
```

## Final `A.java`
```java
class A {
  private int x;

  private static A zero = new A(0); // <--- caching!

  // constructor
  private A(int x) {
    this.x = x;
  }

  // factory method
  public static A construct(int x) {
    if (x == 0) {
      return zero;
    }
    
    return new A(x);
  }
}
```

## That was an example of *caching*
Commonly used instances (e.g., a `Point` at `(0,0)`), can be cached.

## Singleton Recap
In short, a `Singleton` class *caches* its instance in its own static field!
```java
class A {
  // caches its own instance here
  private static A a = new A();

  // impossible to create another instance of A
  private A() {
    // does nothing here
  }

  public static A construct() {
    // returns the one and only instance of A
    return a;
  }
}
```
