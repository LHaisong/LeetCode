package com.prac.bytedance.datastructure;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 设计LRU缓存机制
 */
class LRUCache {
    static List<Integer> keys;
    static HashMap<Integer,Integer> key_values;
    static int capacity;
    public LRUCache(int capacity){
        keys=new ArrayList<>();
        key_values=new HashMap<>(capacity);
        this.capacity=capacity;
    }
    public void put(int k,int v){
        if(!keyHasExist(k)){
            if(keys.size()<capacity) {
                keys.add(k);
                key_values.put(k, v);
            }else {
                int key=keys.get(0);
                key_values.remove(key);
                keys.remove(0);
                keys.add(k);
                key_values.put(k,v);
            }
        }else {
            reOrder(keys,k);
        }
    }
    public static int getVal(int k){
        if(key_values.containsKey(k))
            return key_values.get(k);
        return -1;
    }

    private void reOrder(List<Integer> keys, int k) {
        for(int i=0;i<capacity;i++){
            int j=i+1;
            int val=keys.get(i);
            if(val==k){
                if(j<capacity){
                    keys.set(i,keys.get(j));
                    keys.set(j,val);
                }
            }
        }
    }
    private boolean keyHasExist(int k) {
        for(int i=0;i<keys.size();i++){
            if(keys.get(i)==k){
                return true;
            }
        }
        return false;
    }
    static class Test{
        public static void main(String[]args){
            LRUCache lru=new LRUCache(2);
            lru.put(1,1);
            lru.put(2,2);
            lru.put(3,3);
            lru.put(4,4);
            System.out.println(lru.getVal(2));
        }
    }
}