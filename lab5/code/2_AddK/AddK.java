class AddK implements Transformer<Integer, Integer> {
  int k;

  AddK(int k) {
    this.k = k;
  }

  @Override
  public Integer transform(Integer t) {
    return t + k;
  }
}

/* run the following commands in terminal: */
//    jshell Transformer.java BooleanCondition.java AddK.java Box.java
//    Box.of(4).map(new AddK(3));

/**
 * ----- snippets from the CS2030S textbook -----
 * 
 * "if the anonymous class is extending an interface,
 *    then there is no constructor, but we still need ()"
 * 
 * "we cannot have a constructor for an anonymous class."
 * 
 */

/* ----- MY SOLUTION ----- */
Box.of(4).map(new Transformer<Integer, Integer> () {
  @Override
  public Integer transform(Integer t) {
    return t + 3;
  }
});