package com.jarics.generics;

/**
 * That is a fully generic class. It can accept any data types.
 * @param <T>
 */

public class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add("Hello World");

        System.out.printf("Integer Value :%d\n\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());

        //Why can't I used lambda expression as:
        //stringBox.get( System.out::println );
        //Here's the answer:
        MyPrinter wMyPrinter = (Box a) -> {System.out.println(a.get());};
        wMyPrinter.printAll(stringBox);

    }

    /**
     * Little amusement here to keep the Lambda expression alive....not worth it in real life.
     */
    private interface MyPrinter  {
        void printAll(Box a);
    }
}