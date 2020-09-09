# Breaking-Java
Java is a broken language that no one should use to build software.

In a nutshell, Java's type-system ***does not*** satisfy progress: there exist well-typed Java programs that get stuck in evaluation.

Here is why:

*More examples forthcoming!*

### Array Sub-typing is only Covariant

Java's array sub-typing rule resembles:
```
   B <: A
------------[Bad-Array-Sub-typing]
 B[] <: A[]
```
which is ***covariant*** with respect to `B` and `A`.

This is problematic because arrays may be written to as well as read from. If one declares an array and then copies it to another variable of the super-type:
```
B[] b = new B[1];
A[] a = b;
```
one may then ***destroy assumptions*** about what properties elements of `b` may have if elements of `a` are re-assigned:
```
a[0] = new A();
```
Now `b[0] = a[0]`.

Thus array (and reference-subtyping in general) must be ***invariant***: both covariant and ***contravariant***.
```
 B <: A   A <: B
-----------------[Good-Array-Sub-typing]
    B[] <: A[]
```
Run the example to see how Java deceives one by allowing such a program.
