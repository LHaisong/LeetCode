package com.prac.bytedance.string;

/**
 * 输入3个字符串，求他们最长公共前缀
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class LongestSamePrefix {
    public static void main(String[]args){
        String str1="flower",str2="flow",str3="flight";
        String[]strings={str1,str2,str3};
        String res=getSamePrefix(str1,str2,str3);
        String res2=longestCommonPrefix(strings);
        System.out.println("蛮力法： "+res);
        System.out.println("分治法： "+res2);
    }

    /**
     * 使用分治法求解该问题
     * @param strings
     * @return
     */
    private static String longestCommonPrefix(String[] strings) {
        if(strings.length==0){
            return "不存在公共前缀";
        }
        return LongestCommonPrefix(strings,0,strings.length-1);
    }

    private static String LongestCommonPrefix(String[] strings, int l, int r) {
        if(l==r){
            return strings[1];
        }
        int mid=(l+r)>>1;
        String lcpLeft=LongestCommonPrefix(strings,r,mid);
        String lcpRight=LongestCommonPrefix(strings,mid,r);
        return commonPrefix(lcpLeft,lcpRight);
    }
    private static String commonPrefix(String lcpLeft, String lcpRight) {
        int min=Math.min(lcpLeft.length(),lcpRight.length());
        for(int i=0;i<min;i++){
            if(lcpLeft.charAt(i)!=lcpRight.charAt(i))
                return lcpLeft.substring(0,i);
        }
        return lcpLeft.substring(0,min);
    }
    /**
     * 蛮力法，最坏的情况下复杂度为（假设3个字符串中最长两个长度为m,n）O（mn）
     * @param str1
     * @param str2
     * @param str3
     * @return
     */
    private static String getSamePrefix(String str1, String str2, String str3) {
        int len1=str1.length(),len2=str2.length(),len3=str3.length();
        StringBuffer res=new StringBuffer();
        for(int i=0;i<len1;i++){
            char c1=str1.charAt(i);
            for(int j=i;j<len2;j++){
                char c2=str2.charAt(j);
                if(c1==c2){
                    res.append(c1);
                    break;
                }
                if(c1!=c2){
                    break;
                }
            }
        }
        String res1=res.toString();
        StringBuffer res2=new StringBuffer();
        for(int i=0;i<res1.length();i++){
            char c1=res1.charAt(i);
            for(int j=i;j<len3;j++){
                char c2=str3.charAt(j);
                if(c1==c2){
                    res2.append(c1);
                    break;
                }
                if(c1!=c2){
                    break;
                }
            }
        }
       return res2.toString();
    }
}
