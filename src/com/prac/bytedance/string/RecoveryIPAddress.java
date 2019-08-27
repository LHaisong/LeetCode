package com.prac.bytedance.string;

import java.util.ArrayList;
import java.util.List;

public class RecoveryIPAddress {
    public static void main(String[]args) throws Exception {
        String tar="255255111552";
        List<String>res=recoveryIPAddress(tar);
        if(res.size()==0){
            System.out.println("不存在这样IP地址....");
        }
        for(String s:res){
            System.out.println(s);
        }
    }

    /**
     * 暴力枚举
     * @param tar
     * @return
     * @throws Exception
     */
    private static List<String> recoveryIPAddress(String tar) throws Exception {
        if(tar.length()==0||tar.length()>12){
            throw new Exception("非法输入...");
        }
        int len=tar.length();
        List<String>res=new ArrayList<>();
        for(int i=0;i<4&&i<len-2;i++){
            for(int j=i;j<i+4&&j<len-1;j++){
                for(int k=j;k<j+4&&k<len;k++){
                    String s1=tar.substring(0,i),s2=tar.substring(i,j),
                            s3=tar.substring(j,k),s4=tar.substring(k,len);
                    if(isValid(s1)&&isValid(s2)&&isValid(s3)&&isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }

    private static boolean isValid(String s) {
        if(s.length()>3||s.length()==0||(Integer.parseInt(s)==0&&s.length()>1)||Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }
}
