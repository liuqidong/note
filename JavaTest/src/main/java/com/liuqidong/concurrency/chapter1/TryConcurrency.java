package com.liuqidong.concurrency.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @author liuqidong
 * @version 1.0.0
 * @ClassName TryConcurrency.java
 * @Description TODO
 * @createTime 2020年01月20日 12:52:00
 */
public class TryConcurrency {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Thread("Read-Thread"){
            @Override
            public void run() {
               readFromDataBase();
            }
        }.start();

        new Thread("Writer-thread"){
            @Override
            public void run() {
               writeDataToFile();
            }
        }.start();

    }

    private static void readFromDataBase(){
        try {
            println("Begin read data from db.");
            TimeUnit.SECONDS.sleep(50);
            println("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    private static void writeDataToFile(){
        try {
            println("Begin write data to file.");
            TimeUnit.SECONDS.sleep(20);
            println("Writer data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    private static void println(String message){
        System.out.println(message);
    }

}
