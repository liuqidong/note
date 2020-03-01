package com.liuqidong.concurrency.chapter2;

/**
 * @author liuqidong
 * @version 1.0.0
 * @ClassName Bank2.java
 * @Description TODO
 * @createTime 2020年01月20日 15:37:00
 */
public class Bank2 {
    public static void main(String[] args) {
        TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();

        new Thread(ticketWindowRunnable, "1号窗口").start();
        new Thread(ticketWindowRunnable, "2号窗口").start();
        new Thread(ticketWindowRunnable, "3号窗口").start();
    }
}
