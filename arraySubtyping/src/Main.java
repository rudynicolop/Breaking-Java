public class Main {

    static class A {
        int a;
        // A's constructor
        A(int a) {
            this.a = a;
        }
    }

    static class B extends A {
        int b;
        // B's constructor
        B(int a, int b) {
            super(a);
            this.b = b;
        }
    }

    public static void main(String[] args) {

        // Java's reference semantics seem to
        // work fine for naked objects.
        B b = new B(2,4);

        A a = b;

        a = new A(42);

        // refers to b, not a
        System.out.println(b.b);

        // However, this breaks when
        // objects are embedded in other
        // reference types like arrays.

        // declaration of array of B
        B[] barr = new B[1];

        A[] aarr = barr;

        aarr[0] = new A(42);

        // Throws java.lang.ArrayStoreException
        System.out.println(barr[0].b);
    }
}