abstract class Box<T> {
  public static <T> Box<T> ofNullable(T t) {
    if (t != null) {
      return nonEmpty(t);
    }   
    return empty();
  }

  public static <T> Box<T> empty() {
    @SuppressWarnings("unchecked")
    Box<T> box = (Box<T>) Empty.EMPTY;
    return box;
  }

  public static <T> Box<T> nonEmpty(T t) {
    return new NonEmpty<T>(t);
  }

  public abstract boolean isPresent();
  public abstract Box<T> filter(BooleanCondition<? super T> condition);

  private static class Empty extends Box<Object> {
    private static final Empty EMPTY = new Empty();

    @Override
    public boolean isPresent() {
      return false;
    }   

    @Override
    public Box<Object> filter(BooleanCondition<? super Object> condition) {
      return empty();
    }   

    @Override
    public String toString() {
      return "[]";
    }   
  }

  private static class NonEmpty<T> extends Box<T> {
    private final T t;

    public NonEmpty(T t) {
      this.t = t;
    }   

    @Override
    public boolean isPresent() {
      return true;
    }

    @Override
    public Box<T> filter(BooleanCondition<? super T> condition) {
       if (condition.test(this.t) == false) {
         return empty();
       }

       return (Box<T>)this;
    }

    @Override
    public String toString() {
      return String.format("[%s]", this.t);
    }
  }
}