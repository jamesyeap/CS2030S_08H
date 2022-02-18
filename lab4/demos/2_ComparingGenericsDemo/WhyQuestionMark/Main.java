public class Main {
  public static void main(String[] args) {
    A a = new A();
    B b = new B();

    Box<A> b1 = new Box<>(a);
    Box<B> b2 = new Box<>(b);

    System.out.println(b1.equals(b2));
  }
}
