class A {
  // constructs a single instance of A and stores it 
  // as a CLASS field
  private static A a = new A();

  private A() {
    // empty constructor, since
    // there are no fields in A yet
    // for you to fill in
  }

  public static A construct() {
    // returns the same instance of A!
    return a;
  }
}
