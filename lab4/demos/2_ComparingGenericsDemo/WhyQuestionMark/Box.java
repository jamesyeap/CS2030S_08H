class Box<T> {
  private T x;

  public Box(T x) {
    this.x = x;
  }

  @Override
  public boolean equals(Object o) {
    // first, most obvious check:
    if (o == this) { // compare the memory-addresses
      return true;   // if same memory-address, means its the same instance!
    }

    if (o instanceof Box) {
      Box other = (Box) o;
      
      // second check: compare the memory-addresses of x
      if (other.x == this.x) {
        return true;
      }

      // handle null
      if (this.x == null || other.x == null) {
        return false;
      }

      return this.x.equals(other.x);
    }

    return false;
  }
}
