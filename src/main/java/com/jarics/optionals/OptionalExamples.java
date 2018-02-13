package com.jarics.optionals;

import java.util.Optional;

/**
 * https://www.tutorialspoint.com//java8/java8_optional_class.htm
 *
 * Optional was introduced in Java8 to clarify and ensure that source code can better handle null values or (noResult).
 * This should minimized nullPointerExceptions at runtime.
 *
 */

public class OptionalExamples {
    public static void main(String args[]){

        OptionalExamples java8Tester = new OptionalExamples();
        Integer value1 = null;
//      Integer value2 = new Integer(10);
        Integer value2 = null;

        //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - throws NullPointerException if passed parameter is null
        try {
            Optional<Integer> b = Optional.of(value2);
            System.out.println(java8Tester.sum(a, b));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Optional.of - will be ok since to contains a value
        value2 = new Integer(10);
        try {
            Optional<Integer> b = Optional.of(value2);
            System.out.println(java8Tester.sum(a, b));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        //Optional.isPresent - checks the value is present or not

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.orElse - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }
}
