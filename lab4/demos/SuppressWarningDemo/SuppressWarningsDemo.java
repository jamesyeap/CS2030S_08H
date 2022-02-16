// refer to: https://nus-cs2030s.github.io/2021-s2/22-unchecked.html

class A {
	// do nothing
}

public class SuppressWarningsDemo {
	public static void main(String[] args) {
		// ✅
		@SuppressWarnings("unchecked")
		A a1 = (A) new Object(); // this is OK, since you are DECLARING a new variable a1 of type A

		// ❌
		@SuppressWarnings("unchecked")
		a1 = (A) new Object(); // this is not OK, since you are ASSIGNING the existing variable a1 to another object
	}
}