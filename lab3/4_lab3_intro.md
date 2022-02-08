% Lab 3
% CS2030S
% 10 Feb 2022

# More Queues ⏱

## tldr
- each `counter` now has a queue, which has a maximum capacity of `L`
- the `shop` still has a queue, which has a maximum capacity of `M`

---

## which queue to join?
- If some `counter` is available when a customer arrives, the customer will go straight to that `counter`
-  If all the `counter` are busy, the customer will join `counter` queue that is the ***shortest*** and wait
- If all the `counter` queues are full, the customer will join the `shop` queue and wait
- If even the `shop` queue is full, the customer will leave immediately

---

## advancing the queue
- when a `counter` is done serving a customer, one customer from the `shop` queue may join the queue of that `counter`
- *the rest are straightforward*

---

## edge cases
- if more than one `counter` are available, a customer will go to the `counter` with the ***smallest id*** (just like Lab 2)
-  if there are two `counters` with the same queue length, a customer will join the `counter`'s queue with the ***smallest id***

--- 

# Your Tasks ✏️

## What you need to do
1. make `Queue` a generic class
2. create a generic `Array<T>` class
3. make your `Counter` `Comparable` to itself
4. update your simulation by incorporating `Queue<T>`, `Array<T>` and `Counter`
5. update your `toString()` methods

--- 

## Task 1: Make `Queue` a generic class
remember the `Queue` class given to you in Lab 2?  
make it a generic class `Queue<T>`

## Testing your `Queue<T>`
```bash
javac -Xlint:rawtypes QueueTest.java
java QueueTest
```

## Task 2: Complete the generic `Array<T>` class
> "... we want to replace `ServiceCounter[]` with `Array<ServiceCounter>`"  

## what can `Array<T>` take in?
make it so that `Array<T>` takes in only a ***subtype*** of `Comparable<T>` as its type argument  

you will have to use raw type while implementing this class,  
- use `@SuppressWarnings("rawtypes")` at the ***smallest scope possible***
- to suppress the warning about raw types.

## additional notes for your `Array<T>` class
`min` returns the minimum element  

how?  

based on the `compareTo` method of the `Comparable<T>` interface

## Testing your `Array<T>`
```java
javac -Xlint:rawtypes ArrayTest.java
java ArrayTest
```

## CS2030S notes on `Array<T>` 
you may refer to the `Array<T>` class from the notes  
[CS2030S Notes](https://nus-cs2030s.github.io/2122-s2/25-unchecked.html)

## Task 3: make your `Counter` `Comparable` to itself
> "You should implement compareTo in such a way that counters.min() returns the counter that a customer ***should join*** (unless all the counter queues have reached maximum length)"

hint: if two `Counter` have the same queue length, the `Counter` with the ***smaller id*** would be the one that the Customer should join 😃

## Task 4: Update your simulation
Update your code to use the new classes `Array<T>` and `Queue<T>` where appropriate.

## Task 5: Update your `toString()` methods
if the customer joins a shop queue
```bash
1.400: C3 joined shop queue [ C1 C2 ]
```
if the customer joins a counter queue
```bash
1.200: C2 joined counter queue (at S0 [ C1 ])
```
whenever a counter is printed, print its queue too
```bash
2.000: C0 service done (by S0 [ C1 C2 ])
```

# Good luck! 😃