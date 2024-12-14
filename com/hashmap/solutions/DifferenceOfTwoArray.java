package com.hashmap.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DifferenceOfTwoArray {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> h1=new HashSet<>();
        HashSet<Integer> h2=new HashSet<>();

        for(int i:nums1){
            h1.add(i);
        }
        for(int i:nums2){
            h2.add(i);
        }
        for(int n:nums2){
            if(h1.contains(n)){
                h1.remove(n);
                h2.remove(n);
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>(h1));
        res.add(new ArrayList<>(h2));
        return res;
    }
}
