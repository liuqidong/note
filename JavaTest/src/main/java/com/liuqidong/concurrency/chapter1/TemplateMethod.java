package com.liuqidong.concurrency.chapter1;

/**
 * @author liuqidong
 * @version 1.0.0
 * @ClassName TemplateMethod.java
 * @Description TODO
 * @createTime 2020年01月20日 14:46:00
 */
public class TemplateMethod {

    public void print(String message){
        System.out.println("#################");
        warpPrint(message);
        System.out.println("#################");
    }

    public void warpPrint(String message) {

    }

    public static void main(String[] args) {
        TemplateMethod templateMethod = new TemplateMethod(){
            @Override
            public void warpPrint(String message) {
                System.out.println("*"+message+"*");
            }
        };
        templateMethod.print("helloworld");
    }
}
