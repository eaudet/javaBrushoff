package com.jarics.lambda;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class PredicateTest {
    static public void main(String[] args){
        Predicate<String> wFirst = t -> {
          System.out.println("A");
          return t.startsWith("Hello");
        };

        Predicate<String> wSecond = t -> {
            System.out.println("B");
            return t.endsWith("Champion");
        };
        wFirst.and(wSecond).test("Well hello Champion");


        BiFunction<Boolean, Boolean, Boolean> wAndFunc = (t, u) -> {
            boolean wRes = t && u;
            System.out.println(t + " && " + u + " IS " + wRes);
            return wRes;
        };

        BiFunction<Boolean, Boolean, Boolean> wAndFuncII = (t, u) -> {
            boolean wRes = t & u;
            System.out.println(t + " & " + u + " IS " + wRes);
            return wRes;
        };

        System.out.println("** & Table **");


        wAndFuncII.apply(true, true);
        wAndFuncII.apply(true, false);
        wAndFuncII.apply(false, true);
        wAndFuncII.apply(false, false);


        System.out.println("** && Table **");

        wAndFunc.apply(true, true);
        wAndFunc.apply(true, false);
        wAndFunc.apply(false, true);
        wAndFunc.apply(false, false);

    }

}
