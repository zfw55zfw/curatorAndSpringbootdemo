package com.show.zookeeper.threadPool;

import java.util.concurrent.TimeUnit;

/**
 * @author zhengfawei
 * @create 2020-04-17 下午4:31
 * @desc
 **/
public class MyThread implements Runnable{

    private final int id;

    public MyThread(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        for (int i = 0;i < 5;i++) {
            System.out.println("TaskInPool-["+id+"] is running phase-"+i);
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("TaskInPool-["+id+"] is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
