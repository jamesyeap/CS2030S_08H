% Exercise in Exception
% CS2030S
% 10 Feb 2022

## Would this compile? 🧐

```java
import java.io.File;
import java.util.Scanner;

class ExceptionDemo {
  public static void main(String[] args) {
    File f = new File("hello.txt");
    Scanner s = new Scanner(f);
  }
}
```

---

## Let's take a look at `Scanner` API
[Javadocs](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html#%3Cinit%3E(java.io.File))

## Solution
So, we need to add a `try/catch` block!
```java
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class ExceptionDemo {
  public static void main(String[] args) {
    File f = new File("hello.txt");

    try {
      Scanner s = new Scanner(f);
    } catch (FileNotFoundException e) {
      // do something
    }
  }
}
```

---

## Would this compile? 🧐

```java
import java.io.File;
import java.util.Scanner;

class ExceptionDemo {
  public static Scanner openFile(String filename) {
    File f = new File(filename);
    return new Scanner(f);
  }

  public static void main(String[] args) {
    Scanner sc = openFile("hello.txt");
  }

}
```

---

## Solution 1
Throw the exception to the caller of the method!
```java
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class ExceptionDemo {
  public static Scanner openFile(String filename) throws FileNotFoundException {
    File f = new File(filename);
    return new Scanner(f);
  }

  public static void main(String[] args) {
    try {
      Scanner sc = openFile("hello.txt");
    } catch (FileNotFoundException e) {
      // do something
    }
  }

}
```

---

## Solution 2
Handle it inside the method.
```java
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class ExceptionDemo {
  public static Scanner openFile(String filename) {
    File f = new File(filename);

    try {
      return new Scanner(f);
    } catch (FileNotFoundException e) {
      return null;
    }
  }

  public static void main(String[] args) {
    Scanner sc = openFile("hello.txt");
    // ⚠️ we need to handle the case if null is returned!
    // else, we may get a NullPointerException 😱
  }

}
```

---

# Write your own exception!

## Write a class that throws a new checked exception `MyOwnException`

```java
class ExceptionDemo {
  public static void foo() {
    // todo: throw "MyOwnException"
  }

  public static void main(String[] args) {
    // any changes to make here? 🧐
    foo();
  }

}
```

---

## Solution
```java
// Answer
class MyOwnException extends Exception {

}
class ExceptionDemo {
  public static void foo() throws MyOwnException {
    throw new MyOwnException();
  }

  public static void main(String[] args) {
    try {
      foo();
    } catch (MyOwnException e) {
      // do something
    }
  }
}
```
