package com.som.springboot.generationAlgorithm;

public class Cross {
    /**
     * 交叉操作 交叉率为0.4~0.8根据稳定度进行动态改变，平均为60%的染色体进行交叉
     */
    public void cross() {
        String temp1, temp2;
        double crossRate = 0.4;
        for (int i = 1; i < Val.ITERATIONS / 100 + 1; i++) {
            if (Val.lineNum > (Val.ITERATIONS / 100) * i ){
                crossRate = crossRate + 0.02;
            }
        }
        if (crossRate > 0.8)crossRate = 0.8;
        for (int i = 0; i <  Val.CHROMOSOME_NUM; i++) {
            if (Math.random() < crossRate) {
                int pos = (int)(Math.random()*Val.GENE_NUM)+1;     //pos位点前后二进制串交叉
                temp1 = Val.populationChromosome[i].substring(0, pos) + Val.populationChromosome[(i + 1) %  Val.CHROMOSOME_NUM].substring(pos);
                temp2 = Val.populationChromosome[(i + 1) %  Val.CHROMOSOME_NUM].substring(0, pos) + Val.populationChromosome[i].substring(pos);
                Val.populationChromosome[i] = temp1;
                Val.populationChromosome[(i + 1) /  Val.CHROMOSOME_NUM] = temp2;
            }
        }
    }
}
