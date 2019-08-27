package com.prac.pageReplacement;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用linkedhashmap实现 LRU算法
 */
public class PageLRUTwo {

    static class LRU<K,V>extends LinkedHashMap<K,V>implements Map<K,V>{
        public LRU(int cap,float loadFactor,boolean accOrder){
            super(cap,loadFactor,accOrder);
        }
        protected boolean removeEldestEntry(Map.Entry<K,V>oldest){
            if(size()>3){
                return true;
            }
            return false;
        }
    }

    public static void main(String[]args){
        LRU<Integer,Integer>lru=new LRU<>(16,0.75f,true);
        int[] arr = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        for(int i=0;i<arr.length;i++){
            lru.put(arr[i],i);
        }
        System.out.println(lru);
    }
}
