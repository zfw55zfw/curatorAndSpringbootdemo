package com.show.zookeeper.threadPool;

import com.show.zookeeper.curator.MyThreadCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhengfawei
 * @create 2020-04-17 下午4:29
 * @desc
 **/
public class ThreadPool {
    public static void main(String[] args) {
//       new ThreadPoolExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> list = new ArrayList();
        for (int i = 0; i <5 ; i++) {
            Future future = executorService.submit(new MyThreadCallable(i));
            list.add(future);
        }
        new Thread(()->{
            try {
                Future fs = list.get(0);
                while(!fs.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally{
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }
        }).start();
        new Thread(()->{
            try {
                Future fs = list.get(1);
                while(!fs.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally{
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }
        }).start();
        new Thread(()->{
            try {
                Future fs = list.get(2);
                while(!fs.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally{
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }
        }).start();
        new Thread(()->{
            try {
                Future fs = list.get(3);
                while(!fs.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally{
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }
        }).start();
        new Thread(()->{
            try {
                Future fs = list.get(4);
                while(!fs.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally{
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }
        }).start();
        //遍历任务的结果
//        for (Future fs : list){
//            try{
//                while(!fs.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
//                System.out.println(fs.get());     //打印各个线程（任务）执行的结果
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }catch(ExecutionException e){
//                e.printStackTrace();
//            }finally{
//                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
//                executorService.shutdown();
//            }
//        }

//        Thread thread = new Thread(new MyThread(1));
//        thread.start();
//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("11111");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }
}
