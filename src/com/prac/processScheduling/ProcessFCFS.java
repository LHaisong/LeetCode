package com.prac.processScheduling;

import java.util.LinkedList;
import java.util.List;

/**
 * java实现进程调度算法
 * 先来先服务算法
 */
public class ProcessFCFS {
    public static final int WAIT_MAX=5;
    public static List<Process>waitQueue=new LinkedList<>();
    //CPU忙
    public static final boolean BUSY=true;
    //CPU空闲
    public static final boolean IDLE=true;
    public static void FCFS(List<Process>processes)throws InterruptedException{
        int count=processes.size();
        int order=0;
        boolean cpu=IDLE;
        if(count==0){
            System.out.println("无可用进程");
            return;
        }
        while (count>0){
            System.out.println("第 "+order+" 个进程");
            for(int i=0;i<processes.size();i++){
                if(cpu){
                    cpu=BUSY;
                    doProcess(processes.get(i));
                    cpu=IDLE;
                }else {
                    if(waitQueue.size()<WAIT_MAX){
                        /**
                         *清除已经死掉的进程
                         */
                        for(int j=0;j<waitQueue.size();j++){
                            if(!waitQueue.get(j).isAlive()){
                                waitQueue.remove(j);
                            }
                        }
                        waitQueue.add(processes.get(i));
                    }else {
                        processes.get(i).destroy();
                    }
                }
            }
        }
    }

    private static void doProcess(Process p)throws InterruptedException {
        //防止进程已死
        if (p.isAlive()) {
            System.out.println("开始服务进程 " + p);
            Thread.sleep(1000);
            System.out.println("进程执行完毕");
        }
        else {
            System.out.println("进程"+p+"已死...");
        }
    }
    public static void main(String[]args){

    }
}
