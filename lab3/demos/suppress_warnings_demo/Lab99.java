class A<T> {
	public A() {}
}

// @SuppressWarnings("rawtypes") /* ❌ naw man whatchu doin fam ❌ */
public class Lab99 {	
	public static void main(String[] args) {		
		// @SuppressWarnings("rawtypes")
		A a1 = new A(); // raw type 🥩

		// @SuppressWarnings("rawtypes")
		A a2 = new A(); // raw type 🥩

		// @SuppressWarnings("rawtypes")
		A a3 = new A(); // raw type 🥩
	}
}

// compile this file using javac -Xlint:rawtypes Lab99.java