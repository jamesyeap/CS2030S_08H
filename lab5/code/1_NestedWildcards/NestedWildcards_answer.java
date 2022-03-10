class Animal { }
class Dog extends Animal { }
class Box<T> { }

// class A {
//   static <T> void foo(Box<List<T>> box) {  }
// }

// A.<Animal>foo(new Box<List<Animal>>());			// ✅
// A.<Animal>foo(new Box<List<Dog>>()); 			// ❌
// A.<Animal>foo(new Box<ArrayList<Animal>>());		// ❌
// A.<Animal>foo(new Box<ArrayList<Dog>>());		// ❌

// class A {
//   static <T> void foo(Box<? extends List<T>> box) { }
// }

// A.<Animal>foo(new Box<List<Animal>>());			// ✅
// A.<Animal>foo(new Box<List<Dog>>()); 			// ❌
// A.<Animal>foo(new Box<ArrayList<Animal>>());		// ✅
// A.<Animal>foo(new Box<ArrayList<Dog>>());		// ❌

// class A {
//   static <T> void foo(Box<? extends List<? extends T>> box) { }
// }

// A.<Animal>foo(new Box<List<Animal>>());			// ✅
// A.<Animal>foo(new Box<List<Dog>>()); 			// ✅
// A.<Animal>foo(new Box<ArrayList<Animal>>());		// ✅
// A.<Animal>foo(new Box<ArrayList<Dog>>());		// ✅
