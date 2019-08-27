package com.prac.swordtooffer;

import java.util.HashMap;

/**
 * 输入一个字符串，求第一个只出现过一次的字符
 */
public class Offer_33FirstOnlyOneChar {
    public static void main(String[]args){
        String str="baaacdbefgg";
        System.out.println(findChar(str));
    }

    private static char findChar(String str) {
        if(str.isEmpty()){
            return ' ';
        }
        HashMap<Character,Integer> map=new HashMap<>();
        int num=1;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(map.containsKey(c)){
                int val=map.get(c);
                map.put(c,++val);
            }else {
                map.put(str.charAt(i),num);
            }
        }
//        for(Map.Entry<Character,Integer>entry:map.entrySet()){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
        char res=' ';
        for(char c:map.keySet()){
            int val=map.get(c);
            if(val==1) {
                res = c;
                break;
            }
        }
        return res;
    }
}
