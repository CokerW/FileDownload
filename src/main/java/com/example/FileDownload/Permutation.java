package com.example.FileDownload;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        String a = getPermutation(3,2);
        System.out.println(a);
    }

    //算法设计题目
    //题目描述：
    //大家知道，给出正整数n，则1到n这n个数可以构成n！种排列，把这些排列按照从小到大的顺序（字典顺序）列出，
    //如n=3时，列出1 2 3，1 3 2，2 1 3，2 3 1，3 1 2，3 2 1六个排列。
    //任务描述：
    //给出某个排列，求出这个排列的下k个排列，如果遇到最后一个排列，则下1排列为第1个排列，即排列1 2 3…n。
    //比如：n = 3，k=2 给出排列2 3 1，则它的下1个排列为3 1 2，下2个排列为3 2 1，因此答案为3 2 1。
    //输入
    //第一行是一个正整数m，
    //表示测试数据的个数，下面是m组测试数据，每组测试数据第一行是2个正整数n( 1 <= n < 1024 )和k(1<=k<=64)，
    //第二行有n个正整数，是1，2 … n的一个排列。
    //输出
    //对于每组输入数据，输出一行，n个数，中间用空格隔开，表示输入排列的下k个排列。
    //样例输入
    //3
    //3 1
    //2 3 1
    //3 1
    //3 2 1
    //10 2
    //1 2 3 4 5 6 7 8 9 10
    //样例输出
    //3 1 2
    //1 2 3
    //1 2 3 4 5 6 7 9 8 10

    //原题太难本人不会，只能写到求n！下的第k个排列
    public static String getPermutation(int n, int k) {
        // 阶乘数
        int[] factorialNum = new int[n];
        // 把k转换为从0开始的下标
        k = k - 1;
        // 阶乘数的最低位必然为0
        factorialNum[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            factorialNum[n - i - 1] = k % (i + 1);
            k /= i + 1;
        }
        // 从1到n的全部数字
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }

        // 把阶乘数转换为具体的排列
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 阶乘数的权重即为应当选取的数字的下标
            sb.append(nums.get(factorialNum[i]));
            // 移除已经用过的数字
            nums.remove(factorialNum[i]);
        }
        return sb.toString();
    }

}