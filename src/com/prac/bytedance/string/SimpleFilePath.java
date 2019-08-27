package com.prac.bytedance.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 简化文件路径
 */
public class SimpleFilePath {
    public static void main(String[]args){
        String tar="/a/../../b/../c//.//";
        String res=simplyPath(tar);
        System.out.println(res);
    }

    private static String simplyPath(String tar) {
        String[]strArr=tar.split("/");
        Stack<String>stack=new Stack<>();
        for(String s:strArr){
            if(!stack.isEmpty()&&s.equals("..")){
                stack.pop();
            }
            if(!s.equals(".")&&!s.equals("")&&!s.equals("..")){
                stack.push(s);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        List<String> list=new ArrayList<>(stack);
        return "/" + String.join("/", list);
    }
}
