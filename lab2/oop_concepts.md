% OOP Concepts
% CS2030S
% 3 Feb 2022

# Quick Recap

## Abstract class

(yes, the same animal example again)

```java
class Animal {
	public String getNoise() {
		return "how would i know 🙃"
	}
}

class Lion extends Animal {
	public String getNoise() {
		return "RAWRRRRR 🦁";
	}
}

class Cow extends Animal {
	public String getNoise() {
		return "MOOOOOOO 🐄";
	}
}
```

---

Is there anything wrong here?

```java
class Zoo {
	Animal[] allAnimals;

	public Zoo() {
		allAnimals = new Animal[3];
		allAnimals[0] = new Lion();
		allAnimals[1] = new Cow();
		allAnimals[2] = new Animal();
	}

	public void makeAnimalNoise() {
		for (Animal a : allAnimals) {
			System.out.println(a.getNoise());
		}
	}
}
```

---

Yes!

```bash
RAWRRRRR 🦁			# ok
MOOOOOOO 🐄			# ok
how would i know 🙃 # bruh yo wtf is this
```

---

Abstract classes cannot be instantiated!

```java
// we change the class Animal to abstract

abstract class Animal {
	// no implementation needed! (because we don't know yet)
	public abstract String getNoise();
}
```
---

```java
class Zoo {
	Animal[] allAnimals;

	public Zoo() {
		allAnimals = new Animal[3];
		allAnimals[0] = new Lion();
		allAnimals[1] = new Cow();
		allAnimals[2] = new Animal(); // ❌ COMPILER WILL THROW AN ERROR HERE! 😃
	}

	public void makeAnimalNoise() {
		for (Animal a : allAnimals) {
			System.out.println(a.getNoise());
		}
	}
}
```

## Interface
For modeling "can do" behaviour.

---

This tells us that all classes that implement this interface will have a method called `getNoise`!
```java
interface GetNoisable {
	// all methods declared in an interface are
	// public abstract by default

	String getNoise();
}
```

---

```java
abstract class Animal implements GetNoisable {
	/* NO NEED to include the method here since we 
	already have the interface */
	// ❌ public abstract String getNoise(); ❌ 
}

abstract class InanimateObjects {
	// such as rocks, pencils, etc...
}
```

## Wrapper class
Basically a class that contains a primitive value; such as `int`, which has the wrapper-class `Integer`.

---

Why do we need wrapper classes?

```java
// ❌ cannot input primitive-type inside type-parameter!
List<int> numList = new ArrayList<>();

// ✅ okay because Integer is a reference-type
List<Integer> numList = new ArrayList<>();
```

---

Auto-boxing

```java
Integer i = 4; // an instance of Integer is created
int j = i;     // the value of the Integer object is assigned to the primitive variable j
```

# OOP Modelling Exercise! 🤺

## Scenario (taken from Midterm - AY19/20 Sem 2)

---

The COVID-19 Task Force is developing a system to keep track of confirmed COVID-19 `cases` in Singapore.

---

Each confirmed `case` has an integer case id.

---

There are two types of confirmed `cases`: imported and local.

- For each imported case (and only imported case), the system keeps track of the country the case is imported from.
- For each confirmed case, the system keeps track of the contacts of the case

---

A `contact` is another confirmed `case` (can be either local or imported).

- A case can have zero or more contacts. 
- Each contact is labelled with the nature of the contact, which can be either one of the three: casual contact, close contact, family member.

---

The `cases` can be grouped into `clusters`. 

- Each cluster has a name (a String). 
- A cluster can contain one or more cases. 
- But a case might not necessarily belong to a cluster. 
- A case can belong to multiple clusters.

--- 

Important operations are:

- Given a cluster, find all cases in the cluster.
- Given a cluster, find all important cases in the cluster.
- Given a case, find all close contact of the case.


--- 

Sketch out a diagram showing the classes you would create, and lines connecting related-classes; i.e

- `class A` is a subclass of `class B` (inheritance) (IS-A)
- `class A` contains `class B` (composition) (HAS-A)

---

The goal here is not to come up with a single correct solution, but to explore the different possible designs and the pros/cons of each.

---

Pay attention to the OOP principles: inheritence, LSP, encapsulation, etc.

You have 5 minutes ⏰

---

Share your solution! Any volunteers?

---

jk RNG time 🎲

---
