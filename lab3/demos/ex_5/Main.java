class D<T> {
  T[] a;

  // constructor
  D() {
    // tell compiler it's okay
    @SuppressWarnings("unchecked") 
    T[] tmp = (T[]) new Object[10];

    this.a = tmp;
  }
}

public class Main {
	public static void main(String[] args) {
    D<String> d = new D<String>(); // T[] a 
                                   // is now
                                   // String[] a
	}
}
