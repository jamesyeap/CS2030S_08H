class A {
  @Override
  public boolean equals(Object o) {
    if (o instanceof A) {
      return true;
    }

    if (o instanceof B) {
      return true;
    }

    return false;
  }
}
