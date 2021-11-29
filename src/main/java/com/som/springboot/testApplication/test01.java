package com.som.springboot.testApplication;


import java.util.Arrays;

public class test01 {
    public static int[] moutainTop = {500,300,800,300,270,570};
    public static int[] result = {1,1,1,1,1,1};
    public static int toppest;
    public static void main(String[] args){


        for (int i=1;i<5;i++){
            //左边
            if (i==2){
                result[1] = 2;
            }else if (i>2){
                toppest = moutainTop[i - 2];
                for (int k=i-3; k>-3; k--)
                if (moutainTop[k]>toppest){
                    result[k-1]+=1;
                    toppest=moutainTop[k];
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }

//    private static void compute(int index) {
//        if (moutainTop[index]>toppest){
//            result[index-1]+=1;
//            toppest=moutainTop[index];
//        }
//        compute(index-1);
//    }
}
