# Lab 1 ~~mistakes~~ areas for improvement

## Not breaking up ShopEvent into various Event types (Polymorphism)

```java
public ShopEvent extends Event {
 // fields that every Event should have
 // perhaps time? but, Event already has it!

 // so, is ShopEvent necessary then?
}

public ArrivalEvent extends ShopEvent {
    // ...
}
// or, can we just extend from "Event?"
public ArrivalEvent extends Event {
    // ...
}
```

## Customer class

```java
// previously, each Event only has customerId

// but, what if we wanted to add additional behaviour for a Customer?
// example: what if the Customer arrived and got informed by MOH of
// recent contact with someone with COVID?
// would he/she still be able to say, continue 
// going to a Counter and start shopping?

// with a Customer class, we can model such behaviour!
class Customer {
    boolean hasCovid;

    // ...

    boolean hasCovid() {
        return this.hasCovid;
    }
}

// then, in ServiceBeginEvent, we can check if the Customer is still
// fit to shop :D
class ServiceBeginEvent {
    // ...

    @Override
    public void simulate() {
        if (this.customer.hasCovid()) {
            // faster leaveeeeeeeeeee
        } else {
            // continue shopping
        }
    }
}
```

## Counter class

```java
// same motivation as the Customer class:
//     what if the Counter staff got COVID also?
//     then we need to find a replacement staff!
```

## Be careful of typos

```java
  // "avialable" -> "available"
class Servicebegin(Customer c,boolean[] avialable, int counterid){
    super(c.getArrivaltime());
    this.c=c;
    this.available=available; // this.available = null
    this.counterid=counterid;
  }

  // may cause NullPointerException to be thrown if you pass
  // this.available to another class that attempts to access or
  // modify the array!
```

## Not following the Java Style Guide

```java
// incorrect naming; not in CamelCase
class Serviceendevent extends ShopEvent {
    // ...
}
class Service_Begin extends ShopEvent {
    ...
}

// correct naming!
class ServiceBeginEvent {
    // ...
}
```

[Link to CS2030S Java Style Guide](https://nus-cs2030s.github.io/2021-s2/style.html)

## Tell, Don't Ask

```java
// a shop HAS counters!
class Shop {
  private CheckoutCounter[] counters;

  // creates a new CheckoutCounter instance for each
  // counter the shop has!
  Shop(int numOfCounters) {
    counters = new CheckoutCounter[numOfCounters];
    for (int i = 0; i < numOfCounters; i++) {
      counters[i] = new CheckoutCounter();
    }
  }

  //  returns a CheckoutCounter if one is available,
  //  if not, returns null
  public CheckoutCounter getAvailableCounter() {
    for (CheckoutCounter c : counters) {
      if (c.isAvailable()) {
        return c;
      }
    }
    return null;
  }
}
```

# Pro-tips

## Debugging

Debugging is very tedious, and depressing at times. Fortunately, there are many things you can do to make the process much easier.

## How to debug failed testcases

Learn this technique well, and you'll panic less during PE!

```bash
# inputs the first testcase to your program, and saves
# the output in "Lab1.1.results"
java Lab1 < inputs/Lab1.1.in > Lab1.1.results

# compares the output produced by your program and
# the correct output (any differences will be highlighted)
vim -d Lab1.1.results outputs/Lab1.1.out
```

## get-results.sh

A shell-script I wrote that does the above process for you (it's in the Google drive!).

BUT, still learn the technique above, as you probably won't be able to use this script in your PE!