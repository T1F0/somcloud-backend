package com.som.springboot.generationAlgorithm.service;

import com.som.springboot.generationAlgorithm.*;
import com.som.springboot.generationAlgorithm.Initialization.GAInitialization;

import java.util.Arrays;

public class GAService {


    GAInitialization initialization = new GAInitialization();
    Select select = new Select();
    CalculateFitness calculateFitness = new CalculateFitness();
    Cross cross = new Cross();
    Mutation mutation = new Mutation();

    public String start() {
        Val.populationChromosome = initialization.initPop(); //初始化生成种群
        Val.bestFitness = Double.MAX_VALUE;  //函数最优解
        Val.bestGeneration = 0;    //所有子代与父代中最好的代
        Val.bestChromosome = Val.populationChromosome[0];        //最优解的染色体的二进制码
        //循环迭代
        for (int i = 0; i < Val.ITERATIONS; i++) {
            select.select();
            cross.cross();
            mutation.mutation();
            Val.generation = i;
        }
        return "最小值为ֵ" + Val.bestFitness + '\n' + "第"
                + Val.bestGeneration + "个染色体:<" + Val.bestChromosome + ">" + '\n'
                + Arrays.toString(calculateFitness.calculateFitnessValue(Val.bestChromosome))
                + '\n' + "y=" + calculateFitness.calculateFitnessValue(Val.bestChromosome)[Val.INDIVIDUAL_NUM];
    }
}
