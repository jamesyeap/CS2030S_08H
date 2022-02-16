public class A<T> {
	private T x;

	public A(T x) {
		if (x == null) {
			return null; // ❌ error: incompatible types: unexpected return value
						 // 		(you cannot return null from a constructor 😅)
		}

		this.x = x;
	}
}