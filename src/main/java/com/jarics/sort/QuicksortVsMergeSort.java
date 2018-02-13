package com.jarics.sort;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuicksortVsMergeSort {
    static Logger logger = Logger.getLogger("QuicksortVsMergeSort");


    public static void main(String[] args){
        int[] inputArr = new int[200000];

        for (int i = 0; i < 200000; i++) {
            inputArr[i] = new Random().nextInt();
        }

        //BigO to test
        double wNLogN = inputArr.length * Math.log(inputArr.length);
        double wN2 = inputArr.length * 2;

        MyMergeSort mms = new MyMergeSort();
        long wStart = System.currentTimeMillis();
        mms.sort(inputArr);
        computeBigO("Mergesort", inputArr.length, wStart, wN2);

        MyQuickSort sorter = new MyQuickSort();
        wStart = System.currentTimeMillis();
        sorter.sort(inputArr);
        computeBigO("QuickSort", inputArr.length, wStart, wN2);

        wStart = System.currentTimeMillis();
        Arrays.sort(inputArr);
        computeBigO("Java Sort", inputArr.length, wStart, wN2);

    }

    static private void computeBigO(String pIntent, int wNumberOfTuples, long wStart, double pLogN) {
        float wElapse = System.currentTimeMillis() - wStart;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        logger.log(Level.INFO, "Computing BigO for "+ pIntent + " = "+ formatter.format(pLogN) +
                ". Elapse is :" + formatter.format(wElapse) + ". Test passed? "+ (wElapse < pLogN) );
    }
}
