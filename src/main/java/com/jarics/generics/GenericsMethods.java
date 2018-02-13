package com.jarics.generics;

/**
 * https://www.tutorialspoint.com/java/java_generics.htm
 *
 * Generics was introduced in Java8. It enables to write generic source code. It also enables type safe
 * parameters at compile time.
 *
 */
public class GenericsMethods {
    // generic method printArray
    public static < E > void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    // determines the largest of three Comparable objects

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;   // assume x is initially the largest

        if(y.compareTo(max) > 0) {
            max = y;   // y is the largest so far
        }

        if(z.compareTo(max) > 0) {
            max = z;   // z is the largest now
        }
        return max;   // returns the largest object
    }

    public static void main(String args[]) {
        // Create arrays of Integer, Double and Character
        {
            Integer[] intArray = {1, 2, 3, 4, 5};
            Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
            Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

            System.out.println("Array integerArray contains:");
            printArray(intArray);   // pass an Integer array

            System.out.println("\nArray doubleArray contains:");
            printArray(doubleArray);   // pass a Double array

            System.out.println("\nArray characterArray contains:");
            printArray(charArray);   // pass a Character array
        }

        // Determine the type of classes that can be handle by the generic method. Here, the
        // parameters must be of type Comparable.
        {
            System.out.printf("Max of %d, %d and %d is %d\n\n",
                    3, 4, 5, maximum( 3, 4, 5 ));

            System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",
                    6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));

            System.out.printf("Max of %s, %s and %s is %s\n","pear",
                    "apple", "orange", maximum("pear", "apple", "orange"));

            System.out.printf("Max of %s, %s and %s is %s\n","pear",
                    "apple", "orange", maximum("pear", "apple", "orange"));

            MyComparable aa = new MyComparable(1);
            MyComparable bb = new MyComparable(20);
            MyComparable cc = new MyComparable(10);

            System.out.printf("Max of %s, %s and %s is %s\n", aa, bb, cc, maximum(aa, bb, cc));

           // this should not compile (simply uncomment the next 4 lines).
//            ANotComparable aaa = new ANotComparable(1);
//            ANotComparable bbb = new ANotComparable(20);
//            ANotComparable ccc = new ANotComparable(10);
//            System.out.printf("Max of %s, %s and %s is %s\n", aaa, bbb, ccc, maximum(aaa, bbb, ccc));

        }

        {

        }
    }

    private static class MyComparable implements Comparable{
        public Integer var;
        private MyComparable(int a){
            this.var = a;
        }

        @Override
        public int compareTo(Object o) {
            if (o != null)
                return var.compareTo(((MyComparable)o).var);
            return 0;
        }

        @Override
        public String toString() {
            return var.toString();
        }
    }

    private static class ANotComparable{
        public Integer var;
        private ANotComparable(int a){
            this.var = a;
        }
        @Override
        public String toString() {
            return var.toString();
        }
    }
}
