% Lab 1 Review
% CS2030S
% 3 Feb 2022 

## Break up ShopEvent into various Event types
ShopEvent is really bloated.
```java
/* ShopEvent.java */
class ShopEvent extends Event {
    // contains code for ArrivalEvent, ServiceBeginEvent, 
    // yada yada 😒
}

```

---

Can we break up ShopEvent into various classes that **only** contain the necessary fields and methods? 🧐

```java
/* ArrivalEvent.java */
class ArrivalEvent extends Event {
    // ...
    @Override
    public String toString() {
        // no need to check for eventType here! 😃
    }

    @Override
    public Event[] simulate() {
        // also no need to check for eventType here! 😃
    }
}

/* ServiceBeginEvent.java */
class ServiceBeginEvent extends Event {
    // ...
}

/* ServiceEndEvent.java */
class ServiceEndEvent extends Event {
    // ...
}

/* DepartureEvent.java */
class DepartureEvent extends Event {
    // ...
}
```

## Create a Customer class

Currently, we only have `customerId` to identify the customer.

---

But, what if we wanted to *add additional behaviour* for a Customer?

---

For example, what if the Customer arrived and got informed by MOH of recent contact with someone with COVID? 😱

---

Would he/she still be able to continue heading to a Counter and start shopping? 🦠

---

(can is can ah, but... 👮‍♂️)

---

With a `Customer` class, we can model such behaviour!

```java
/* Customer.java */

class Customer {
    boolean hasCovid;
    // ... other fields

    boolean hasCovid() {
        return this.hasCovid;
    }

    // ... other methods
}
```

---

Then in the various Event classes, we can add continuously check if the customer needs to leave! 😃

```java
/* ServiceBeginEvent.java */

class ServiceBeginEvent { // then we can check if the Customer is still fit to shop :D
    // ... other fields and methods

    @Override
    public Event[] simulate() {
        if (this.customer.hasCovid()) {
            return new Event[] {
                // a new type of Event
                new QuarantineCustomerEvent(...)
            }
        } else {
            // ... other code here
        }
    }
}
```

## Create a Counter class
What if we wanted to let a counter serve TWO customers? 👨‍🦱👩‍🦰

---

Currently, we ***can't*** 😅

```java
/* ShopEvent.java */

public boolean[] available;

// counter 0 is initially available
available[0] = true;

// customer one arrives and goes to counter 0
available[0] = false;

// customer two arrives, but sees that counter 0 is unavailable, 
// even though one more customer can be served 😱
```

---

With a `Counter` class, we **can** make this happen! 😃

```java
/* Counter.java */

class Counter {
    int id;
    int capacity;
    int nCustomers;
    Customer[] customersAtCounter;

    public Counter(int capacity) {
        this.capacity = capacity;
        this.nCustomers = 0;
        this.customersAtCounter = new Customer[capacity];
    }

    // returns true if the Counter can still serve another customer!
    public boolean hasSlot() {
        return this.capacity > nCustomers;
    }
}
```

## Whose job is it to find an available counter?
The shop! 

---

So, we create a method inside the `Shop` class that returns Counter to us!
```java
// a shop HAS counters!
class Shop {
  private Counter[] counters;

  // creates a new CheckoutCounter instance for each
  // counter the shop has!
  Shop(int numOfCounters) {
    counters = new Counter[numOfCounters];
    for (int i = 0; i < numOfCounters; i++) {
      counters[i] = new Counter();
    }
  }

  //  returns a CheckoutCounter if one is available,
  //  if not, returns null
  public Counter getAvailableCounter() {
    for (Counter c : counters) {
      if (c.isAvailable()) {
        return c;
      }
    }
    return null;
  }
}
```

## Be careful of typos 
```java
/* Servicebegin.java */

public Servicebegin (Customer c,boolean[] avialable, int counterid) { // note the typo here: "avialable"
    super(c.getArrivaltime());
    this.c=c;
    this.available=available;
    this.counterid=counterid;
  }
```

## Follow the Java Style Guide
```java
// incorrect naming; not in CamelCase 🐫
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

# Some Tips
## How to debug failed testcases
Learn this technique well, and PE will be easier!

```bash
# inputs the first testcase to your program, and saves
# the output in "Lab1.1.results"
java Lab1 < inputs/Lab1.1.in > Lab1.1.results

# compares the output produced by your program and
# the correct output (any differences will be highlighted)
vim -d Lab1.1.results outputs/Lab1.1.out
```

## `get-results.sh`
A shell-script I wrote that does the above process for you.

```bash
# inside your PE server,
git clone git@github.com:jamesyeap/CS2030S_08H.git

# copy the bash-script into the specific lab folder
cp CS2030S_08H/get-results.sh <lab_name>-<your_github_username>
# example: cp CS2030S_08H/get-results.sh lab1-jamesyeap

# go into the lab folder,
cd <lab_name>-<your_github_username>
# example: cd lab1-jamesyeap

# run the script and follow the prompts!
bash get-results.sh
```

---

HOWEVER, you probably won't be able to use this script in your PE, so just make sure you know the official debugging technique well! 😃

```bash
# inputs the first testcase to your program, and saves
# the output in "Lab1.1.results"
java Lab1 < inputs/Lab1.1.in > Lab1.1.results

# compares the output produced by your program and
# the correct output (any differences will be highlighted)
vim -d Lab1.1.results outputs/Lab1.1.out
```