package com.prac.bytedance.string;

import java.util.*;

/**
 * 最长无重复字符串长度
 * 例："abcabcbb" ---->3
 *    "bbbbbbb" ----->1
 *
 */
public class LongestNoRepeatString {
    public static void main(String[]args){
        String str="abcabcdbb";
        //int len=getLength(str);
        int len=getLen(str);
        System.out.println(len);
    }
    private static int getLength(String s){
        if(s.length()==0){
            return 0;
        }
        Map<Character,Integer>charMap=new HashMap<>();
        /**
         *maxLen用于存放最大长度，没有出现重复的字符指
         * 向第一个字符，在逐渐向后推移的过程中总是从前面的字符串开始出现重复
         * 每次只要出现重复就将now往后移一位
         */
        int maxLen=0,now=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(charMap.containsKey(ch)){
                now=Math.max(charMap.get(ch)+1,now);
                if(i-now+1>maxLen){
                    maxLen=i-now+1;
                }
            } else {
                if(i-now+1>maxLen){
                    maxLen=i-now+1;
                }
            }
            charMap.put(ch,i);
        }
        return maxLen;
    }
    /**
     * hashset实现
     */
    private static int getLen(String s){
        HashSet<Character>set=new HashSet<>();
        int res=0,left=0,right=0,len=s.length();
        while (right<len){
            char ch=s.charAt(right);
            if(!set.contains(ch)){
                set.add(ch);
                right++;
                res=Math.max(res,set.size());
            }else {
                set.remove(left++);
            }
        }
        return res;
    }
}
