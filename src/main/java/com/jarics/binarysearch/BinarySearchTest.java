package com.jarics.binarysearch;

import java.util.*;

public class BinarySearchTest {

    static public void main(String[] args) {
        int[] inputArr = new int[200000];

        inputArr[0] = 999;
        for (int i = 1; i < 200000; i++) {
            inputArr[i] = Math.abs(new Random().nextInt());
        }

        Arrays.sort(inputArr);
        int wFound = Arrays.binarySearch(inputArr, 999);
        System.out.println(wFound);

        String[] inputStrArr = new String[20000];
        inputStrArr[0] = "Boom";
        for (int i = 1; i < 20000; i++) {
            inputStrArr[i] = "a" + new Random().nextInt();
        }
        Arrays.sort(inputStrArr);
        int res = Arrays.binarySearch(inputStrArr, "Boom");
        System.out.println(res);

        BinarySearchTest wBinarySearchTest = new BinarySearchTest();
        wBinarySearchTest.testMyClass();

    }

    public void testMyClass() {
        TestMyClass wTestMyClass = () -> {
            List<MyClass> inputMyArr = new ArrayList<MyClass>();
            for (int i = 1; i < 200000; i++) {
                MyClass wMyClass = new MyClass("MyClass" + Math.abs(new Random().nextInt()));
                if (i == 65625) {
                    inputMyArr.add(new MyClass("coucou"));
                }else {
                    inputMyArr.add(new MyClass("MyClass"+Math.abs(new Random().nextInt())));
                }

            }
            Collections.sort(inputMyArr);
            int wRes = Arrays.binarySearch(inputMyArr.toArray(), new MyClass("coucou"));
            System.out.println(wRes);
            return wRes;
        };
        wTestMyClass.testAll();
    }

    public interface TestMyClass {
        int testAll();
    }

    public class MyClass implements Comparable {

        private String key;

        public MyClass(String pKey) {
            key = pKey;
        }

        public String getKey() {
            return key;
        }

        @Override
        public int compareTo(Object o) {
            MyClass wMyClass = (MyClass) o;
            return wMyClass.getKey().compareTo(key);
        }
    }


}
