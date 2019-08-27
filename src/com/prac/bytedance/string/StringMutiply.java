package com.prac.bytedance.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class StringMutiply {
    public static void main(String[]args){
        String s1="123",s2="456";
        String res=mutiply(s1,s2);
        System.out.println(res);
    }

    private static String mutiply(String s1, String s2) {
        int m=s1.length(),n=s2.length(),len=m+n;
        char[]chS1=s1.toCharArray();
        char[]chS2=s2.toCharArray();
        int[]val=new int[m+n];
        StringBuffer sb=new StringBuffer();
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul=(chS1[i]-'0')*(chS2[j]-'0');
                int pos1=i+j,pos2=i+j+1;
                int sum=mul+val[pos2];
                val[pos1]+=sum/10;
                val[pos2]=sum%10;
            }
        }
        for(int j=(val[0]==0?1:0);j<val.length;j++){
            sb.append(val[j]);
        }
        return sb.length()==0?"0":sb.toString();
    }
}
