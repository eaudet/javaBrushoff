package com.jarics.lambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class BuiltInLamdaInterfaces {
    public static void main (String[] ags){
        Predicate<String> wStringStartsPredicate = t -> t.startsWith("Hello");
        Predicate<String> wStringEndsPredicate = t -> t.endsWith("Arthur");
        boolean wRes = wStringStartsPredicate.and(wStringEndsPredicate).test("Hello you great hines Arthur");

        wRes = Predicate.isEqual("Arthur").test("Arthure"   );
                System.out.println(wRes);

        Predicate<Integer> even = t -> t % 2 == 0;
        System.out.println(even.test(5));

        IntPredicate even2 = t -> t % 2 == 0;
        System.out.println(even2.test(2));

    }




}
