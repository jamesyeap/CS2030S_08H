// Example
class A {
  private int x;
  private static A zero = new A(0);
  private A(int x) {
    this.x = x;
  }
  public static A construct(int x) {
    if (x == 0) {
      return zero;
    }
    return new A(x);
  }
}

