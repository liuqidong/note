package com.liuqidong.java8;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {

    public static void main(String[] args) {
        //匿名内部类到lambda表达式
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("执行线程");
            }
        };

        //lambda表达式
        runnable = ()-> System.out.println("执行线程a");

        new Thread(runnable).start();

        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return Integer.compare(s.length(),t1.length());
            }
        });

        treeSet = new TreeSet<>((o1,o2)->{
            return Integer.compare(o1.length(),o2.length());
        });

        treeSet = new TreeSet<>((o1,o2)->Integer.compare(o1.length(),o2.length()));

        MyNumber myNumber = ()-> 44.4;
        System.out.println(myNumber.getValue());

        Function<Integer,Integer> function = p -> p*10;
        System.out.println(function.apply(10));

        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("helloworld");

        Supplier<Integer> supplier = ()->new Random(10).nextInt();
        System.out.println(supplier.get());

        Predicate<Integer> predicate = p-> p % 20 == 0;
        System.out.println(predicate.test(40));
    }
}
