package com.jarics.stackoverflow;

public class StackOverFlowTest {

    public static void main(String[] args){
        StackOverFlowTest stackOverFlowTest = new StackOverFlowTest();
        stackOverFlowTest.recursiveTest(0);
    }

    private void recursiveTest(int a){
        if (a == -1){
            System.out.println("Final: "+ a);
        } else {
            recursiveTest(++a);
        }
    }

}
