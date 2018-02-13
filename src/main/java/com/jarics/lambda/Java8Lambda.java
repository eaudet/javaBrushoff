package com.jarics.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8Lambda {

    public static void main(String args[]){
        Java8Lambda tester = new Java8Lambda();

        //Implementations of interface MathOperation

        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        //Anonymous class instead of a lambda implementation. This is a lot uglier but still needed when
        //the interface is not a functional class (more than one method)
        MathOperation anOtherMathOper = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        //Without the use of the operate wrapper method
        System.out.println("100 + 5 = " + addition.operation(100, 5));

        //Using an anonymous class
        System.out.println("100 + 5 = " + anOtherMathOper.operation(100,5));

        //without parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //with parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");

        Learn wLearnerOne = (a) -> true;

        List<String> wSamples = Arrays.asList("a", "b", "c");
        System.out.println( wLearnerOne.learnThatThing( wSamples ));


    }

    //This is a functional interface (single method)
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    interface Learn{
        boolean learnThatThing(List<String> samples);
    }

    interface LearnAgain{
        boolean learnThatThing(List<String> samples, Predicate predicate);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    public static boolean isGoodSample(String sample){
        return sample.equals("a");
    }

}

