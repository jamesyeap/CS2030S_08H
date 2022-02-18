import java.util.*;

public class Problem {
	public static void main(String[] args) {
		/* ----- SETUP ----- */

		// we create a list that holds integers
		List<Integer> a = new ArrayList<>();

		// we add 1 to this list
		a.add(1);

		// we can try to add a string to this list, but it won't compile
		// a.add("a"); // since "a" is not an integer! 

		/* ----- where things go horribly wrong ----- */

		// we create a raw-type variable b, and assign a to it
		List b = a; // raw-type reassignment 🥩

		// note that at this point, the variables b and a refer to the
		// SAME list!
		a.add(2);
		System.out.println(b); // prints [1, 2]

		// we try to add a string to this list
		b.add("a"); // it compiles! ❌❌❌❌❌❌❌❌❌❌❌

		/* ----- why this is a problem ----- */

		// we try to sum all the integers in a, then print it out
		int sum = 0;
		for (Integer x : a) {
			sum += x; // runtime error: ClassCastException
		}

		// we had a ClassCastException (because java.lang.String cannot be converted to int)

		System.out.println(sum);
	}
}