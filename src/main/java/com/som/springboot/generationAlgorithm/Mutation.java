package com.som.springboot.generationAlgorithm;

public class Mutation {
    //基因突变操作 1%基因变异
    public void mutation() {
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * Val.GENE_NUM *  Val.CHROMOSOME_NUM + 1);
            int chromosomeNum = (int) (num / Val.GENE_NUM) + 1; // 染色体号

            int mutationNum = num - (chromosomeNum - 1) * Val.GENE_NUM; // 基因号
            if (mutationNum == 0)
                mutationNum = 1;
            chromosomeNum = chromosomeNum - 1;
            if (chromosomeNum >=  Val.CHROMOSOME_NUM)
                chromosomeNum = 9;
            String temp;
            String a;   //记录变异位点变异后的编码
            if (Val.populationChromosome[chromosomeNum].charAt(mutationNum - 1) == '0') {    //当变异位点为0时
                a = "1";
            } else {
                a = "0";
            }
            //当变异位点在首、中段和尾时的突变情况
            if (mutationNum == 1) {
                temp = a + Val.populationChromosome[chromosomeNum].substring(mutationNum);
            } else {
                if (mutationNum != Val.GENE_NUM) {
                    temp = Val.populationChromosome[chromosomeNum].substring(0, mutationNum -1) + a
                            + Val.populationChromosome[chromosomeNum].substring(mutationNum);
                } else {
                    temp = Val.populationChromosome[chromosomeNum].substring(0, mutationNum - 1) + a;
                }
            }
            //记录下变异后的染色体
            Val.populationChromosome[chromosomeNum] = temp;
        }
    }
}
