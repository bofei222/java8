package com.bf;

/**
 * @description:
 * @author: bofei
 * @date: 2020-11-19 09:04
 **/
public class Test08 {
    public static void main(String[] args) {
        double root = 6666;
        while ((root * root - 9) > 0.0000001) {
            root = (root + 9 / root) / 2;
            System.out.println(root);
        }
    }

    public static double squareRoot(double number) {
        if (number < 0) { //小于0的数无法开平方
            return Double.NaN;
        } else {
            double err = 1e-15; //设置误差范围，当误差小于这个值时认为得到准确值
            double root = number;   //给平方根一个预设值
            while (Math.abs(number - root * root) > err) {
                root = (number / root + root) / 2.0;
            }
            return root;
        }

    }
}
