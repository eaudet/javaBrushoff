package com.jarics.streams;

/**
 * https://www.tutorialspoint.com/java8/java8_default_methods.htm
 */

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamsTests {

    public static void main(String args[]){


        StreamsTests wStreamsTests = new StreamsTests();
        wStreamsTests.testFilterStream();
        wStreamsTests.testRandomStream();
        wStreamsTests.testMap();
        wStreamsTests.testCollectors();
        wStreamsTests.testStreamingStatistics();
        wStreamsTests.countEmptyString();
    }

    private void testFilterStream(){
        FilterStream wFilterStream = (list) -> ( list.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()) );
        FilterStream wFilterParallelStream = (list) -> ( list.parallelStream().filter( string -> !string.isEmpty() ).collect(Collectors.toList()) );
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = wFilterStream.testFilterStream(strings);
        filtered.stream().forEach(System.out::println);

        //parallel streaming
        List<String> parallelfiltered = wFilterParallelStream.testFilterStream(strings);
        String wRes = parallelfiltered.stream().collect(Collectors.joining(","));
        System.out.println(wRes);
    }

    private void testRandomStream(){
        Random wRandom = new Random();
        wRandom.ints().limit(10).forEach(System.out::println);
    }

    private void testMap(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        //get list of unique squares
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        squaresList.stream().sorted().forEach(System.out::println);
    }

    private void testCollectors(){
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
    }

    private void testStreamingStatistics(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }

    public String countEmptyString(){
        List<String> wList = Arrays.asList("qaqaws", "", "frfefv", "okodc", "", "edede");
        List<String> wEmptyStrings = wList.stream().filter(s -> s.isEmpty()).collect(Collectors.toList());
        System.out.println("Empty list count: " + wEmptyStrings.size());
        return "Empty list count: " + wEmptyStrings.size();
    }

    public interface FilterStream{
        List<String> testFilterStream(List<String> l);
    }

}
