package com.prac.swordtooffer;

/**
 * 将String类型转换为int类型输出
 */
public class Offer_45StringToInt {
    public static void main(String[]args) throws Exception {
        String s1="123";
        String s2="1a1";
        String s3="";
        String s4="-123";
        String s5="+12";
        String s6="-";
        String s7="+";
        String s8="-+";
        int res=change(s1);
        System.out.println(res);
    }

    private static int change(String s1) throws Exception {
        char[]chars=s1.toCharArray();
        boolean posSym=false,negSym=false;
        if(chars.length==0){
            throw new Exception("空字符串");
        }
        int res=0,len=chars.length,i=0;
        if(len==1&&(chars[i]=='-'||chars[i]=='+')){
            throw new Exception("非法输入.....");
        }
        if(chars[i]=='-'){
            negSym=true;
            i++;
        }
        if(chars[i]=='+'){
            posSym=true;
            i++;
        }
        if(i==2){
            throw new Exception("非法输入，+ -同时存在.....");
        }
        for(;i<len;i++){//0 1 2
            len--;//2 1 0
            if(chars[i]>='0'&&chars[i]<='9') {
                res += (chars[i] - '0') * Math.pow(10, len);
            }else {
                throw new Exception("字符串中含有非数字的字符，无法进行转换.....");
            }
        }
        if(negSym)
            res=-1*res;
        if(res>Integer.MIN_VALUE||res<Integer.MIN_VALUE){
            if(negSym)
                return Integer.MIN_VALUE;
            if(posSym)
                return Integer.MIN_VALUE;
        }
        return res;
    }
}
