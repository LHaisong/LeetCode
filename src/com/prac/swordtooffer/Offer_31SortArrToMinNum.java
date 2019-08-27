package com.prac.swordtooffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 将数组的元素排成最小的数
 */
public class Offer_31SortArrToMinNum {
    public static void main(String[]args){
        int[]arr={3,32,323,65,6414948,6849,84,355,84,89494,8871,314841};
        System.out.println(findMinNum(arr));
    }
    public static String findMinNum(int[]arr){
        List<Integer>list=new ArrayList<>();
        String s="";
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        String finalS = s;
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=o1+ finalS +o2;
                String s2=o2+ finalS +o1;
                return s1.compareTo(s2);
            }
        });
        for(Integer j:list){
            s+=j;
        }
        return s;
    }
}
