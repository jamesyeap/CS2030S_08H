class Box<T> {
  private final T t;

  private static final Box<?> EMPTY = new Box<>(null);

  private Box(T t) {
    this.t = t;
  }

  public static <T> Box<T> ofNullable(T t) {
    if (t == null) {
      return empty();
    }
    return (Box<T>) new Box<>(t);
  }

  public static <T> Box<T> of(T t) {
    if (t == null) {
      return null;
    }
    return new Box<>(t);
  }

  public static <T> Box<T> empty() {
    @SuppressWarnings("unchecked")
    Box<T> box = (Box<T>) EMPTY;
    return box;
  }

  public boolean isPresent() {
    return this.t != null;
  }

  public Box<T> filter(BooleanCondition<? super T> condition) {
    if (!isPresent()) {
      return empty();
    }
    if (condition.test(this.t) == false) {
      return empty();
    }
    return (Box<T>) this;
  }

  public <U> Box<U> map(Transformer<? super T, ? extends U> transformer) {
    if (!isPresent()) {
      return empty();
    }
    return Box.ofNullable(transformer.transform(this.t));
  }

  @Override
  public String toString() {
    if (isPresent()) {
      return "[" + t + "]";
    } else {
      return "[]";
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof Box<?>) {
      Box<?> box = (Box<?>) obj;
      if (this.t == box.t) {
        return true;
      }
      if (this.t == null || box.t == null) {
        return false;
      }
      return this.t.equals(box.t);
    } 
    return false;
  }
}