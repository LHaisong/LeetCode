package com.prac.bytedance.string;

/**
 * 反转字符串中的单词，去掉多余的空格
 */
public class ReverseLetterInString {
    public static void main(String[]args){
        String str="this  is  a  String";
        String res=reverse(str);
        System.out.println(res);
    }
    private static String reverse(String str) {
        String[]strs=str.split(" ");
        StringBuffer sb=new StringBuffer();
        for(int i=strs.length-1;i>=0;i--){
            sb.append(strs[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
