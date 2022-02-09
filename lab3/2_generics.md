% Exercise in Generics
% CS2030S
% 10 Feb 2022

## ✏️ Exercise 1
Declare a generic class with type parameter `T` and a single private field `x` of type `T`

## Solution
```java
class A<T> { 
  private T x;
}
```

## ✏️ Exercise 2
Instantiate an instance of `A<T>` with type argument `Integer`

## Solution
```java
A<Integer> a = new A<Integer>();
```

---

## a quick note from prof
> "we don't encourage type inference yet. So avoid `new A<>()`"

```java
// what we just did
A<Integer> a = new A<Integer>();

// this works too, but avoid it (for now)
A<Integer> a = new A<>();
```

# raw types 🥩

## do ***NOT*** use raw types!
> "this is one of the major sources of ***mark deductions*** in labs and PEs"

```java
class A<T> { 
  private T x;
}

class Main {
  public static void main(String[] args) {
    A a = new A();                   // ❌ raw type; missing <...>
    A<Integer> a = new A<Integer>(); // ✅ OK!
  }
}
```

## how to check for raw types in your code 🔍
```bash
# including -Xlint:rawtypes so your compiler will
# warn you if raw types are used!

javac -Xlint:rawtypes Lab99.java
```

---

## demo (without `Xlint:rawtypes`)
```bash
javac Lab99.java
```

---

## demo (with `Xlint:rawtypes`)
```bash
javac -Xlint:rawtypes Lab99.java
```
```
Lab99.java:8: warning: [rawtypes] found raw type: A
    A a = new A();
    ^
  missing type arguments for generic class A<T>
  where T is a type-variable:
    T extends Object declared in class A
```

## ✏️ Exercise 3
declare a generic class `B<T>` that extends from `A<T>`, and a generic class `C<T>` that contains a field of type `A<T>`

*also, do the occurrences of T refers to the same T?* 🧐

## solution 😃
*do the occurrences of T refers to the same T?* -> YES! 😃
```java
class B<T> extends A<T> { 

}

class C<T> { 
  private A<T> a;

}
```

---

## ✏️ Exercise 4
write a ***generic*** method that copies one array to another
```java
// how .copy(...) is supposed to work

String s[] = new String[2];
String t[] = new String[2];
Integer i[] = new Integer[2];
Integer j[] = new Integer[2];

A.<String>copy(s, t); // ok
A.<Integer>copy(i, j); // ok
A.<String>copy(i, j); // error
A.<String>copy(s, j); // error
```
---

## here's the skeleton code
```java
// skeleton code: replace ??? with your code

class A { 
  public static ??? void copy(???  from, ??? to) {
    for (int i = 0; i < from.length; i++) {
      to[i] = from[i];
    }
  }
}
```
---

## solution
```java
class A { 
  public static <T> void copy(T[] from, T[] to) {
    for (int i = 0; i < from.length; i++) {
      to[i] = from[i];
    }
  }
}
```

---

## HEADS UP! 
these are relevant for Lab 3 😃

---

## ✏️ Exercise 5
write a generic class `D<T>` that contains a field that is an array of type `T` with 10 elements.  

Instantiate that array in the constructor.

---

## solution
```java
class D<T> {
  T[] a;

  // constructor
  D() {
    // silences compiler by telling it that you've
    //   checked this line and that this is OK 
    @SuppressWarnings("unchecked")
    T[] tmp = (T[]) new Object[10];

    this.a = tmp;
  }
}
```

---

## ✏️ Exercise 6
write a generic class `E<T extends Comparable<T>>` that contains a field that is an array of type T with 10 elements.  

Instantiate that array in the constructor.

## solution
```java
class E<T extends Comparable<T>> {
  T[] a;

  // constructor
  E() {
    @SuppressWarnings({"unchecked", "rawtypes"})
    T[] tmp = (T[]) new Comparable[10];

    this.a = tmp;
  }
}
```