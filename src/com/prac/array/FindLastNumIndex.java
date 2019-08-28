package com.prac.array;
import java.util.ArrayList;
import java.util.List;

/**
 * 牛客网删数
 */
public class FindLastNumIndex {
    public static void main(String [] args) {
        int len=9;
        getIndex(len);
    }
/*-0 -1  -3 -4  6 -7*/
    private static void getIndex(int len) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(i);
        }
        int begin=-1;
        for(int i=0;i<len; i++){
            begin=begin+3;
            if(list.size()==1) {
                System.out.println(list.get(0));
            } else {
                if (begin >= list.size()) {
                    begin -= list.size();
                    while (begin>=list.size()){
                        begin -= list.size();
                    }
                    list.remove(begin);
                    begin--;
                } else {
                    list.remove(begin);
                    begin--;
                }
            }
        }
    }
}
