package com.som.springboot.generationAlgorithm;

import com.som.springboot.generationAlgorithm.Initialization.ParameterInitialization;

import java.util.HashMap;
import java.util.Map;

public class CalculateFitness {
    //将染色体转换成变量的值,并且计算适应度值
    public int[] calculateFitnessValue(String str) {
        int[] providerId = new int[Val.INDIVIDUAL_NUM];
        int[] fitnessValue = new int[Val.INDIVIDUAL_NUM + 1];
        ParameterInitialization parameterInitialization = new ParameterInitialization();

        Map<Integer,Integer>[] parameter = parameterInitialization.Parameter();
        for (int i = 0; i < Val.INDIVIDUAL_NUM; i++) {
            //将80个二进制数字转化为16个十进制数。每个数字使用5个二进制字符串表示，范围是2^0~2^5-1，即1~31
            providerId[i] = Integer.parseInt(str.substring(5*i,5*(i+1)),2);
        }
        //目标函数
        int whileTimes = 16;
        while (whileTimes-- != 0)
            fitnessValue[Val.INDIVIDUAL_NUM] = fitnessValue[Val.INDIVIDUAL_NUM] + providerId[whileTimes] * parameter[providerId[whileTimes]].get(0);
        System.arraycopy(providerId, 0, fitnessValue, 0, Val.INDIVIDUAL_NUM);
        return fitnessValue;
    }
}
