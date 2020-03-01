package com.liuqidong.concurrency.chapter2;

/**
 * @author liuqidong
 * @version 1.0.0
 * @ClassName TicketWindow.java
 * @Description TODO
 * @createTime 2020年01月20日 15:26:00
 */
public class TicketWindow extends Thread {
    private String name;
    private static  final Integer MAX = 50;
    private static  Integer index = 1;

    public TicketWindow(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println((this.index++)+"号,请到"+this.name);
        }
    }
}
