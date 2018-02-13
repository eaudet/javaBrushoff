package com.jarics.lambda;

import java.util.function.IntConsumer;

/**
 * A consumer does not return anything
 */
public class ConsumerTest {
    static public void main(String[] args){
        int[] wInts = {1, 2,3,4,5,6};
        IntConsumer wIntConsumer = t -> System.out.print(t);
        printList(wInts, wIntConsumer);

    }

    static void printList(int[] pList, IntConsumer pIntConsumer){
        for (int i = 0; i < pList.length-1; i++) {
            pIntConsumer.accept(pList[i]);
        }
    }


}
