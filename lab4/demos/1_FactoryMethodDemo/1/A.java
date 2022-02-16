class A {
  private A() {
    // empty constructor, since
    // there are no fields in A yet
    // for you to fill in
  }

  public static A construct() {
    // constructs a new instance of A and
    // returns it to the caller
    return new A(); 
  }
}
