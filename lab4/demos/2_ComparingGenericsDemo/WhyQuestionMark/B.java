class B {
  @Override
  public boolean equals(Object o) {
    if (o instanceof B) {
      return true;
    }

    if (o instanceof A) {
      return true;
    }

    return false;
  }
}
