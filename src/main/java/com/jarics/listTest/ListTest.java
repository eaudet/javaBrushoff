package com.jarics.listTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListTest {


    static public void main(String argsp[]) {
        ListTest wListTest = new ListTest();
        wListTest.testConcurrentCollectionsSynchronizedList();
        wListTest.testConcurrentCopyOnWriteArrayList();
    }


    private void testConcurrentCollectionsSynchronizedList() {

        ExecutorService wExecutorService = Executors.newFixedThreadPool(3);

        List<Integer> theList = new ArrayList<Integer>();
        theList.add(10);
        theList.add(20);
        theList.add(30);
        List<Integer> wSyncList = Collections.synchronizedList(theList);

        System.out.println("Testing Collections.synchronizedList");
        for (int i = 0; i < 10; i++) {
            wExecutorService.execute(new MyThread("t" + i, wSyncList));
        }
        wExecutorService.shutdown();
        while (!wExecutorService.isTerminated()) {
        }

    }

    private void testConcurrentCopyOnWriteArrayList() {

        ExecutorService wExecutorService = Executors.newFixedThreadPool(3);

        List<Integer> theConList = new CopyOnWriteArrayList<Integer>();
        theConList.add(10);
        theConList.add(20);
        theConList.add(30);


        System.out.println("CopyOnWriteArrayList");
        for (int i = 0; i < 2; i++) {
            wExecutorService.execute(new MyThread("t" + i, theConList));
        }
        wExecutorService.shutdown();
        while (!wExecutorService.isTerminated()) {
        }
    }


    public class MySyncThread extends Thread {
        List<Integer> list;

        public MySyncThread(String pName, List<Integer> pList) {
            super.setName(pName);
            list = pList;
        }

        @Override
        public void run() {
            StringBuffer wMessage = new StringBuffer("Thread: " + getName() + "\n");
            Iterator<Integer> wIterator = list.iterator();
            synchronized (list) { //sync to make sure updates wont throw exceptions.
                while (wIterator.hasNext()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Integer wI = wIterator.next();
                    wMessage.append(wI + ", ");
                    list.set(list.size() - 1, wI * 10); //Modifies while inside the iterator.
                }
            }
            wMessage.append(list);
            System.out.println(wMessage.toString());

        }
    }

    public class MyThread extends Thread {
        List<Integer> list;

        public MyThread(String pName, List<Integer> pList) {
            super.setName(pName);
            list = pList;
        }

        @Override
        public void run() {
            StringBuffer wMessage = new StringBuffer("Thread: " + getName() + "\n");
            Iterator<Integer> wIterator = list.iterator();
            while (wIterator.hasNext()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer wI = wIterator.next();
                wMessage.append(wI + ", ");
                list.set(list.size() - 1, wI * 10); //Modifies while inside the iterator.
            }
            wMessage.append(list);
            System.out.println(wMessage.toString());

        }
    }

}
