package com.prac.bytedance.string;

import java.util.Arrays;

/**
 * 判断一个字符串是否包含另一个字符串的排列
 */
public class StringPermInclude {
    public static void main(String[]args){
        String tar="abc",str="fdfweabagcsds";
//        if(includePerm(str,tar)){
//            System.out.println("字符串："+tar+" 包含："+str+"的排列");
//        }else {
//            System.out.println("字符串："+tar+" 不包含："+str+"的排列");
//        }
        if(checkinclusion(tar,str)){
            System.out.println("字符串："+str+" 包含："+tar+"的排列");
        }else {
            System.out.println("字符串："+str+" 不包含："+tar+"的排列");
        }
    }

    /**
     * 第一个方法使用求全排列的方法，但是不是最优解，
     * 当字符串长度很大时使用一个数组存放他们是不可取的
     * @param str
     * @param tar
     * @return
     */
    private static boolean includePerm(String str, String tar) {
        int total=1;
        char[]chars=str.toCharArray();
        /**
         * 求得全排列的个数，初始化一个存放全排列的数组
         */
        for(int i=chars.length;i>0;i--){
            total=total*i;
        }
        String[]perm=new String[total];
        for(int i=0;i<total;i++){
            perm[i]=getStringPerm(chars,0,str.length()-1);
        }
        //判断目标字符串是否包含其中一个全排列
        return IncludePerm(tar,perm);
    }
    /**
     *
     * 使用分治法求解全排列
     * @param str
     * @param k
     * @param m
     * @return
     */
    private static String getStringPerm(char[] str,int k,int m) {
        StringBuffer sb=new StringBuffer();
        if(k==m) {
            for(int j=0;j<str.length;j++) {
                sb.append(str[j]);
            }
        }
        else{
            for(int i=k;i<=m;i++) {
                swap(str,k,i);//0 0
                getStringPerm(str,k+1,m);//
                swap(str,k,i);//0
            }
        }
        return sb.toString();
    }
    private static void swap(char[]chars,int i,int k){
        char temp=chars[k];
        chars[k]=chars[i];
        chars[i]=temp;
    }
    private static boolean IncludePerm(String tar, String[] perm) {
        boolean isContain=false;
        for(int i=0;i<perm.length;i++){
            if(tar.contains(perm[i])){
                isContain=true;
                break;
            }
        }
        return isContain;
    }
    /**
     * 第二种方法：不关心排列的形式，而把重心放在数量关系上
     * 使用滑动窗口解决
     * 复杂度为O(n+26*(m-n))
     */
    public static boolean checkinclusion(String s1,String s2){
        int n = s1.length(), m = s2.length();
        int[] arrS1 = new int[26];
        for(int i = 0;i < n;i++){
            arrS1[s1.charAt(i)-'a']++;
        }
        int[] arrS2 = new int[26];
        for(int i = 0;i < m;i++){
            arrS2[s2.charAt(i)-'a']++;//fabacsds
            if(i >= n){
                arrS2[s2.charAt(i-n)-'a']--;
            }
            if(Arrays.equals(arrS1, arrS2))
                return true;
        }
        return false;
    }
    /**
     * 第三种方法：使用排序的思想
     */
    public static boolean checkInclusion(String tar,String s){
        tar=sort(tar);
        for(int i=0;i<s.length()-tar.length();i++){
            if(tar.equals(sort(s.substring(i,i+tar.length())))){
                return true;
            }
        }
        return false;
    }

    private static String sort(String tar) {
        char[]chars=tar.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
