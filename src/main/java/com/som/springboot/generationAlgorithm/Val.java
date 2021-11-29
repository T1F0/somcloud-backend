package com.som.springboot.generationAlgorithm;

public class Val {
    public static final int GENE_NUM = 80; 		//基因数
    public static final int INDIVIDUAL_NUM = 16;
    public static final int  CHROMOSOME_NUM = 32;	//种群中染色体数量
    public static final int ITERATIONS = 10000;     //总的迭代次数
    public static String[] populationChromosome = new String[CHROMOSOME_NUM];	 	//种群中全部个体染色体信息
    public static int generation = 0; 	//迭代次数
    public static double bestFitness = Double.MAX_VALUE;  //函数最优解
    public static int bestGeneration;   	//所有子代与父代中最好的代
    public static String bestChromosome;   		//最优解的染色体的二进制码
    public static int lineNum;          //记录bestFitness不变的次数

}
