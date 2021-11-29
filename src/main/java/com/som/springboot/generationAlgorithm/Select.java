package com.som.springboot.generationAlgorithm;

public class Select {
    /**
     * 轮盘选择
     * 计算群体上每个个体的适应度值;
     * 按由个体适应度值所决定的某个规则选择将进入下一代的个体;
     */
    public void select() {

        CalculateFitness calculateFitness = new CalculateFitness();

        double[] totalFitnessValue = new double[ Val.CHROMOSOME_NUM]; // 当前种群所有染色体适应值
        double sumOfFitness = 0; // 当前种群累计适应值总和
        double[] probability = new double[ Val.CHROMOSOME_NUM]; // 各染色体选择概率
        double[] cumulativeProbability = new double[ Val.CHROMOSOME_NUM]; // 累计概率
        //计算种群所有个体（染色体）的适应度，以及适应度之和
        for (int i = 0; i <  Val.CHROMOSOME_NUM; i++) {
            totalFitnessValue[i] = calculateFitness.calculateFitnessValue(Val.populationChromosome[i])[Val.INDIVIDUAL_NUM];
            if (totalFitnessValue[i] < Val.bestFitness){  // 记录下种群中的最小值，即最优解
                Val.bestFitness = totalFitnessValue[i];
                Val.bestGeneration = Val.generation;
                Val.bestChromosome = Val.populationChromosome[i];
                Val.lineNum = 1;
            }else {
                Val.lineNum ++;
            }
            sumOfFitness = sumOfFitness + totalFitnessValue[i]; // 所有染色体适应值总和
        }
        //计算所有染色体被选择的概率，以及累计概率
        for (int i = 0; i <  Val.CHROMOSOME_NUM; i++) {
            probability[i] = totalFitnessValue[i] / sumOfFitness;
            if (i == 0)
                cumulativeProbability[i] = probability[i];
            else {
                cumulativeProbability[i] = cumulativeProbability[i - 1] + probability[i];
            }
        }
        //按照轮盘赌的概率进行选择，选择合适的个体进入种群
        for (int i = 0; i <  Val.CHROMOSOME_NUM; i++) {
            double r = Math.random();
            if (r <= cumulativeProbability[0]) {
                Val.populationChromosome[i] = Val.populationChromosome[0];
            } else {
                for (int j = 1; j <  Val.CHROMOSOME_NUM; j++) {
                    if (r < cumulativeProbability[j]) {
                        Val.populationChromosome[i] = Val.populationChromosome[j];
                    }
                }
            }
        }
    }
}
