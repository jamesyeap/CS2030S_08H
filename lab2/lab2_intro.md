% Lab 2
% Simulating a Shop with a Queue
% CS2030S

# Previously in Lab 1

---

## no waiting due to COVID-19 restrictions
- the shop is losing customers as a customer departs if all the counters are busy 💸

---

## adding an entrance queue to our shop,
- Lab 2 adds an ***entrance queue*** to the shop
- now, instead of leaving when all counters are busy, a customer will join the queue and wait ⏱

---

## queue behavior
- when a counter becomes available, the customer at the ***front*** of the queue will proceed to the counter for service
- a queue has a maximum length
	- which is specified in the input testcase
	- when the queue is full, any arriving customer will be turned away ✋

---

# Building on Lab 1

---

- in Lab 2, only two classes are given,
	- `Lab2.java`
	- `Queue.java`
- so, copy over all your classes from Lab 1, ***except***
	- `Lab1.java` 
		- (because we'll be using `Lab2.java` for Lab 2)

---	

# Your Tasks
- improve on your design for Lab 1 (if needed)
- update the relevant classes (or add new ones) to simulate the entrance queue
- update the input and output components of the classes to conform to the new specifications
	- the `toString` methods (refer to Question.md in Lab 2)