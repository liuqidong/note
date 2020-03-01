package com.liuqidong.concurrency.chapter2;

/**
 * @author liuqidong
 * @version 1.0.0
 * @ClassName Bank.java
 * @Description TODO
 * @createTime 2020年01月20日 15:32:00
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow("1号窗口");
        TicketWindow t2 = new TicketWindow("2号窗口");
        TicketWindow t3 = new TicketWindow("3号窗口");

        t1.start();
        t2.start();
        t3.start();
    }
}
