package com.liuqidong.chapter15;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        //直接打印一个点
        System.out.println(file.getName());
        //获取父路径
        System.out.println(file.getParent());
        //获取绝对路径
        System.out.println(file.getAbsolutePath());
        //获取上一级文件路径
        System.out.println(file.getAbsoluteFile().getParent());
        //当前目录创建临时文件
        File tempFile = File.createTempFile("aaa",".txt",file);
        tempFile.deleteOnExit();
        //创建新的文件
        File newFile = new File(Long.valueOf(System.currentTimeMillis()).toString());
//        newFile.createNewFile();
        System.out.println("newFile是否存在："+newFile.exists());
//        newFile.mkdir();
        //列出当前目录下的所有文件和路径
        File[] files = file.listFiles();
        Arrays.asList(files).forEach(file1 -> {
            System.out.println(file1.getName());
        });
    }
}
