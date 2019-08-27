package com.prac.swordtooffer;

import java.util.Arrays;

/**
 * 反转一个英文句子
 * 输入：Im a student
 * 输出：student a Im
 */
public class Offer_41ReverseLetterSentence {
    public static void main(String[]args) throws Exception {
        String tar="Im a student.";
        reverseLetter(tar);
        reverse(tar);
    }

    private static void reverseLetter(String tar) throws Exception {
        if(tar==null){
            throw new Exception("单词为null.....");
        }
        String[]tarArr=tar.split(" ");
        for(int i=tarArr.length-1;i>=0;i--){
            System.out.print(tarArr[i]+" ");
        }
    }
    /**
     * 做两次翻转
     * 第一步：翻转所有单词序列res=.tneduts a mI
     * 第二步：逐个翻转单词序列中的单词 res=student a Im
     */
    public static void reverse(String tar){
        String[]tarArr=tar.split(" ");
        int sta=0,end=tarArr.length-1;
        while (sta<end){
            String temp=tarArr[end];
            tarArr[end]=tarArr[sta];
            tarArr[sta]=temp;
            sta++;
            end--;
        }
        String temp;
        for(int i=0;i<tarArr.length;i++){
            temp=reverseWords(tarArr[i]);
            tarArr[i]=null;
            tarArr[i]=temp;
        }
        for(int i=0;i<tarArr.length;i++){
            System.out.print(tarArr[i]+" ");
        }
    }
    public static String reverseWords(String word){
        char temp;
        char[]chars=word.toCharArray();
        int sta=0,end=chars.length-1;
        while (sta<end){
            temp=chars[end];
            chars[end]=chars[sta];
            chars[sta]=temp;
            sta++;
            end--;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<chars.length;i++){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
