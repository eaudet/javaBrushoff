package com.jarics.methodref;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * Source: Java 8 Programmer  II Study Guide
 */
public class MethodRefTest {
    static public void main(String[] args){
        List<Integer> theList = Arrays.asList(10,20,33,40,50,60);
        //Using anonymous class
        printList(Numbers.findNumbers(theList, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer i1, Integer i2) {
                return Numbers.isMoreThanFifty(i1, i2);
            }
        }));
        //Using Lambda expression
        printList(Numbers.findNumbers(theList, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2)));
        //Using method refefence
        printList(Numbers.findNumbers(theList, Numbers::isMoreThanFifty));
    }

    public static void printList(List<Integer> pList){
        Iterator<Integer> wIt = pList.iterator();
        while (wIt.hasNext()){
            System.out.print(wIt.next());
        }
        System.out.println();
    }


}
