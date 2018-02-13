package com.jarics.volatiletest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Source: https://dzone.com/articles/java-volatile-keyword-0
 * <p>
 * If you don't put the keyword (volatile) in front of the variable MY_INT, the ChangeListener
 * will loop for ever without detecting any changes since each thread has it's own
 * copy (local copy) of MY_INT including the ChangeMaker thread. In this case
 * the increment is done only locally.
 */
public class VolatileTest3 {
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");

    private static volatile int MY_INT = 0; //volatile so stick in main memory
    private static String var1;
    private static String var2;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMakerII().start();
        new ChangeMakerII().start();

    }

    static public class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;       //Get initial the copy from main memory
            while (local_value < 5) {       //Enter loop for 5 changes. Changes will happen concurrently.
                if (local_value != MY_INT) {  //Check if change happened.
                    local_value = MY_INT;    //Change happened! Get the copy from main memory to evaluate the while loop.
                    LOGGER.log(Level.INFO, "Got Change for MY_INT : {0}", local_value);
                }
            }
        }
    }

    static class ChangeMakerII extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;       //Get initial the copy from main memory
            while (local_value < 5) {        //Do five changes
                synchronized (this) {
                    try {                    //This is slowing down the writer in order for the listener to copy MY_INT from main memory
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LOGGER.log(Level.INFO, "Incrementing MY_INT to {0}", MY_INT + 1);
                    MY_INT = ++local_value;     //Increment local var and write to main memory (volatile keyword) should put the new value in main memory.
                }
            }
        }
    }
}