package com.som.springboot.generationAlgorithm.Initialization;

import com.som.springboot.generationAlgorithm.Val;

public class GAInitialization {
    //初始化一条染色体（用二进制字符串表示）
    public String initChromosome() {
        String res = "";
        for (int i = 0; i < Val.GENE_NUM; i++) {
            if (Math.random() > 0.5) {
                res += "0";
            } else {
                res += "1";
            }
        }
        return res;
    }

    //初始化一个种群(10条染色体)
    public String[] initPop() {
        String[] populationChromosome = new String[Val.CHROMOSOME_NUM];
        for (int i = 0; i <  Val.CHROMOSOME_NUM; i++) {
            populationChromosome[i] = initChromosome();
        }
        return populationChromosome;
    }
}
