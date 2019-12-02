package com.liuqidong.sparsearray;

/**
 * 稀疏数据
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0:表示没有妻子，1表示黑子 2表示蓝子
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[2][4] = 2;
        System.out.println("原始的二维数组：");
        //输出原始二维数组
        for (int[] row:chessArray1) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //思路
        //1.遍历二维数组得到非零数据的个数
        int sum = 0;
        for (int[] row:chessArray1) {
            for (int data:row) {
                if (data != 0){
                    sum++;
                }
            }
        }
        System.out.println("二维数组非零元素的个数："+sum);

        //2.创建稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //2.1将二位数组中非零的值存储的稀疏数组中
        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if(chessArray1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        //2.2打印稀疏数组
        System.out.println("稀疏数组如下：");
        for (int[] sparseArr : sparseArray) {
            for (int sparseEle : sparseArr) {
                System.out.printf("%d\t",sparseEle);
            }
            System.out.println();
        }

        //将稀疏数组还原
        System.out.println("还原稀疏数组：");
        int[][] sparseToArr = new int[sparseArray[0][0]][sparseArray[0][1]];
        //给数组赋值
        for (int i = 1; i < sparseArray.length; i++) {
            sparseToArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int i = 0; i < sparseToArr.length; i++) {
            for (int j = 0; j < sparseToArr[i].length; j++) {
                System.out.printf("%d\t",sparseToArr[i][j]);
            }
            System.out.println();
        }


    }
}
