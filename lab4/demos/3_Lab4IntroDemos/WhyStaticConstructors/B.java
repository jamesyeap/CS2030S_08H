public class B<T> {
	private T x;

	public B(T x) {
		this.x = x;
	}

	public static <U> B<U> of(U val) {
		if (val == null) { // now you check and make sure that B cannot be instantiated with null!
			return null;
		}

		return new B<U>(val); // only return a new instance of B if the input is non-null
	}
}
