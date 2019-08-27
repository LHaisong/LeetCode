package com.prac.swordtooffer;

/**
 * 在没有+ - * /的条件下做加法运算
 */
public class Offer_44PlusNo {
    public static void main(String[]args){
        int e1=5,e2=13;
        try {
            System.out.println(getSum(e1,e2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 使用二进制的方式实现
     * @param e1
     * @param e2
     * @return
     * @throws Exception
     */
    private static int getSum(int e1, int e2) throws Exception {
        if(e1>Integer.MAX_VALUE||e2>Integer.MAX_VALUE) {
            throw new Exception("超出加数最大限制...");
        }
        int sum,carry;
        while (e2!=0){
            //不考虑进位的结果
            sum=e1^e2;
            //记录进位
            carry=(e1&e2)<<1;
            e1=sum;
            e2=carry;
        }
        if(e1>=Integer.MAX_VALUE||e1<=Integer.MIN_VALUE)
            throw new Exception("结果超出限制.....");
        return e1;
    }
}
