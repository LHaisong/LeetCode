package com.prac.array;

import java.util.TreeMap;

public class ReorderChar {
    public static void main(String[]args){
        String str="eeefgghhh";
        TreeMap<Character,Integer>treeMap=new TreeMap<>();
        for(int i=0;i<str.length();i++){
            if(treeMap.containsKey(str.charAt(i))){
                treeMap.put(str.charAt(i),treeMap.get(str.charAt(i))+1);
            }else {
                treeMap.put(str.charAt(i),1);
            }
        }
        for(int i=0;i<str.length(); i++) {
            for (char c : treeMap.keySet()) {
                if (treeMap.containsKey(c) && treeMap.get(c) > 0) {
                    System.out.print(c);
                    treeMap.put(c, treeMap.get(c) - 1);
                }
            }
        }
    }
}
