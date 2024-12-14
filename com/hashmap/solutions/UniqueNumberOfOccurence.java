package com.hashmap.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurence {
    public boolean uniqueOccurrences(int[] arr) {
        //find the frequency elements .
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int num : arr){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }

        Set<Integer> countMapSet = new HashSet<>(countMap.values());

        return countMap.size() == countMapSet.size();

    }
}
