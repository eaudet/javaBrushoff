package com.jarics.methodref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReference {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //Reference to static method – Class::staticMethodName Math::max
        {
            List<Integer> integers = Arrays.asList(1, 12, 433, 5);
            Optional<Integer> max = integers.stream().reduce(Math::max);
            max.ifPresent(value -> System.out.println(value));
        }

        //Reference to instance method from instance – ClassInstance::instanceMethodName System.out::println
        {
            List<Integer> integers = Arrays.asList(1,12,433,5);
            Optional<Integer> max = integers.stream().reduce(Math::max);
            max.ifPresent( System.out::println );
        }

        //Reference to instance method from class type – Class::instanceMethodName
        {
            List<String> strings = Arrays
                    .asList("how", "to", "do", "in", "java", "dot", "com");
            List<String> sorted = strings
                    .stream()
                    .sorted((s1, s2) -> s1.compareTo(s2))
                    .collect(Collectors.toList());
            System.out.println(sorted);
            List<String> sortedAlt = strings
                    .stream()
                    .sorted(String::compareTo)
                    .collect(Collectors.toList());
            System.out.println(sortedAlt);

        }

        //Reference to constructor – Class::new
        {
            List<Integer> integers = IntStream
                    .range(1, 100)
                    .boxed()
                    .collect(Collectors.toCollection( ArrayList::new ));
            Optional<Integer> max = integers.stream().reduce(Math::max);
            max.ifPresent(System.out::println);
        }


    }

}
