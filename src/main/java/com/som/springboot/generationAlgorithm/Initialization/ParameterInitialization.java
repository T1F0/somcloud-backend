package com.som.springboot.generationAlgorithm.Initialization;

import com.som.springboot.generationAlgorithm.Val;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParameterInitialization {

    public Map<Integer,Integer>[] Parameter(){
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] hashMaps = new HashMap[Val.CHROMOSOME_NUM];
        for (int i = 0; i < Val.CHROMOSOME_NUM; i++) {
            hashMaps[i] = new HashMap<>();
            for (int j = 0; j < Val.CHROMOSOME_NUM; j++) {
                hashMaps[i].put(j,10);
            }
        }
        return hashMaps;
    }
}
