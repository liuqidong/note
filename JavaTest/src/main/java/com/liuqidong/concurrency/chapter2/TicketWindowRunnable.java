package com.liuqidong.concurrency.chapter2;

import java.util.concurrent.TimeUnit;

/**
 * @author liuqidong
 * @version 1.0.0
 * @ClassName TicketWindowRunnable.java
 * @Description TODO
 * @createTime 2020年01月20日 15:35:00
 */
public class TicketWindowRunnable implements Runnable {

    private   final Integer MAX = 50;
    private   Integer index = 1;

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println((this.index++)+"号,请到"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
