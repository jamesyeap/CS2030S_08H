% Comparing Generics
% CS2030S
% 17 Feb 2022

## Last Task

```java
/**
 * Write a generic class B with type parameter `T`
 * 
 *   has a private field `x` of type `T`
 * 
 *   override the `equals` method to compare 
 *     if two instances of type `B` are equal
 */

class B<T> {
  // todo
}
```

---

## Expected Behaviour of B
```
jshell> B<Integer> b = new B<>(4);
b ==> B@26be92ad

jshell> b.equals(b)
$7 ==> true

jshell> b.equals(new B<>(4))
$8 ==> true

jshell> b.equals(new B<String>("hello"))
$9 ==> false

jshell> b.equals(new B<>(null))
$10 ==> false

jshell> b.equals(null)
$11 ==> false
```

## Solution

```java
class B<T> {
  private T x;

  public B(T x) {
    this.x = x;
  }

  @Override
  public boolean equals(Object o) {
    // 1️⃣ quick check: compare the memory-addresses
    if (o == this) {
      // if same memory-address, means its the same instance!
      return true;  
    }

    // 2️⃣ check before casting
    if (o instanceof B<?>) {
      B<?> other = (B<?>) o;
      
      // 3️⃣ compare the memory-addresses of x
      if (other.x == this.x) {
        return true;
      }

      // 4️⃣ check for null case before calling equals()
      if (this.x == null || other.x == null) {
        return false;
      }

      // if no null check above, may have NullPointerException
      // if someone does the following:

      // B<Integer> b1 = new B<>(null);
      // B<Integer> b2 = new B<>(2);
      // b1.equals(b2); ❌ NullPointerException here!
      
      // 5️⃣ tell, don't ask: rely on the equals method of x
      return this.x.equals(other.x);
    }

    return false;
  }
}

```