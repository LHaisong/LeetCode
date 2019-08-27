package com.prac.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 */
public class MergeIntervals {
    public static void main(String[]args){
        int[][]intervals={
                         {1,3},
                         {2,6},
                         {8,10},
                         {15,18}};
        merge(intervals);
    }

    private static void merge(int[][] intervals) {
        List<int[]>temp=new ArrayList<>();
        int[]starts=new int[intervals.length];
        int[]ends=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            starts[i]=intervals[i][0];
            ends[i]=intervals[i][1];
        }
        Arrays.sort(starts);//[1 2 8 15]
        Arrays.sort(ends);//  [3 6 10 18]
        int l=0,r=1;
        while (r<=intervals.length){
            if(r==intervals.length||starts[r]>ends[r-1]){
                int[]sol=new int[]{starts[l],ends[r-1]};
                temp.add(sol);
                System.out.println(Arrays.toString(sol));
                l=r;
            }
            r++;
        }
    }
}
