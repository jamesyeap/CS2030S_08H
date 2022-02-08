class E<T extends Comparable<T>> {
  T[] a;

  // constructor
  E() {
    // tell compiler it's okay
    @SuppressWarnings({"unchecked", "rawtypes"})
    T[] tmp = (T[]) new Comparable[10];

    this.a = tmp;
  }
}

public class Main {
	public static void main(String[] args) {
    E<String> e = new E<String>();
	}
}
