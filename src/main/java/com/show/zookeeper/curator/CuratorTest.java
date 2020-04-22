package com.show.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.transaction.CuratorMultiTransaction;
import org.apache.curator.framework.api.transaction.CuratorOp;
import org.apache.curator.framework.api.transaction.CuratorTransaction;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.utils.EnsurePath;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import redis.clients.jedis.Client;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;

/**
 * @author zhengfawei
 * @create 2020-04-17 下午2:54
 * @desc
 **/
public class CuratorTest {
    //会话超时时间
    private static final int SESSION_TIMEOUT = 30 * 1000;

    //连接超时时间
    private static final int CONNECTION_TIMEOUT = 3 * 1000;

    //ZooKeeper服务地址
    private static final String CONNECT_ADDR = "localhost:2181";

    public static void main(String[] args) throws Exception {
        //1 重试策略：初试时间为1s 重试10次
//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
////        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
////        client.start();
////        client.delete().forPath("/Curatot");
//        //2 通过工厂创建连接
//        CuratorFramework cf = CuratorFrameworkFactory
//                .builder()
//                .connectString(CONNECT_ADDR)
//                .connectionTimeoutMs(CONNECTION_TIMEOUT)
//                .sessionTimeoutMs(SESSION_TIMEOUT)
//                .namespace("curator")
//                .retryPolicy(retryPolicy)
//                .build();
//        //3 开启连接
//        cf.start();
        //创建永久节点
//        cf.create()
//          .forPath("/PERSISTENT_TEST1","PERSISTENT DATA".getBytes());
//        //创建永久有序节点
//        cf.create()
//          .withMode(CreateMode.PERSISTENT_SEQUENTIAL)
//          .forPath("/PERSISTENT_SEQUENTIAL_TEST1","PERSISTENT_SEQUENTIAL DATA".getBytes());
        //创建临时节点
//        cf.create()
//          .withMode(CreateMode.EPHEMERAL)
//          .forPath("/EPHEMERAL_TEST1","EPHEMERAL_TEST DATA".getBytes());
//        //创建临时有序节点
//        cf.create()
//          .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
//          .forPath("/EPHEMERAL_SEQUENTIAL_TEST1","EPHEMERAL_SEQUENTIAL_TEST DATA".getBytes());
//        //测试检查某个节点是否存在
//        new Thread(()->{
//            try {
//                while (true) {
//                    Stat stat = cf.checkExists().forPath("/PERSISTENT_TEST3");
//                    Stat stat1 = cf.checkExists().forPath("/EPHEMERAL_TEST3");
//                    System.out.println("'/PERSISTENT_TEST3'是否存在： " + (stat != null ? true : false));
//                    System.out.println("'/EPHEMERAL_TEST3'是否存在： " + (stat1 != null ? true : false));
//                    TimeUnit.SECONDS.sleep(5);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();

        //获取某个节点数据
//        System.out.println(new String(cf.getData().forPath("/PERSISTENT_TEST1")));
//
//        //设置某个节点数据
//        cf.setData().forPath("/PERSISTENT_TEST1","/PERSISTENT_TEST1 modified data".getBytes());
//
//        System.out.println(new String(cf.getData().forPath("/PERSISTENT_TEST1")));

//        orSetData()方法：如果节点存在则Curator将会使用给出的数据设置这个节点的值，相当于 setData() 方法
//        creatingParentContainersIfNeeded()方法：如果指定节点的父节点不存在，则Curator将会自动级联创建父节点
//        guaranteed()方法：如果服务端可能删除成功，但是client没有接收到删除成功的提示，Curator将会在后台持续尝试删除该节点
//        deletingChildrenIfNeeded()方法：如果待删除节点存在子节点，则Curator将会级联删除该节点的子节点
        //创建测试节点

//         cf.create().orSetData().creatingParentContainersIfNeeded()
//             .forPath("/curator/del_key1","/curator/del_key1 data".getBytes());
//
//         cf.create().orSetData().creatingParentContainersIfNeeded()
//         .forPath("/curator/del_key2","/curator/del_key2 data".getBytes());
//
//         cf.create().forPath("/curator/del_key2/test_key","test_key data".getBytes());
//        Stat stat = cf.checkExists().forPath("/curator/del_key1");
//        System.out.println("'/curator/del_key1'是否存在： " + (stat != null ? true : false));
//
//        //删除该节点
//         cf.delete().forPath("/curator/del_key1");
//        Stat stat1 = cf.checkExists().forPath("/curator/del_key1");
//        System.out.println("'/curator/del_key1'是否存在： " + (stat1 != null ? true : false));
//
//         //级联删除子节点
//        cf.delete().guaranteed().deletingChildrenIfNeeded().forPath("/curator/del_key2");


                /* 事务管理：碰到异常，事务会回滚
         * @throws Exception
         */
        //定义几个基本操作
//        cf.create().forPath("/curator1");
//        CuratorOp createOp = cf.transactionOp().create()
//                .forPath("/curator1/one_path","some data".getBytes());
//
//        CuratorOp setDataOp = cf.transactionOp().setData()
//                .forPath("/curator1","other data".getBytes());
//        CuratorOp setDataOp1 = cf.transactionOp().setData()
//                .forPath("/curator1",null);
//        CuratorOp deleteOp = cf.transactionOp().delete()
//                .forPath("/curator1");
//        //事务执行结果
//        List<CuratorTransactionResult> results = cf.transaction()
//                .forOperations(createOp,setDataOp,setDataOp1);
//
//        //遍历输出结果
//        for(CuratorTransactionResult result : results){
//            System.out.println("执行结果是： " + result.getForPath() + "--" + result.getType());
//        }
////因为节点“/curator”存在子节点，所以在删除的时候将会报错，事务回滚
//
//        cf.delete().guaranteed().deletingChildrenIfNeeded().forPath("/curator1");

//        try {
//            cf.start();
//            // 开启事务
//            CuratorMultiTransaction transaction = cf.transaction();
//            transaction.
//            Collection<CuratorTransactionResult> results1 = transaction.create()
//                    .forPath("/a/path", "some data".getBytes()).and().setData()
//                    .forPath("/another/path", "other data".getBytes()).and().delete().forPath("/yet/another/path")
//                    .and().commit();
//
//            for (CuratorTransactionResult result : results1) {
//                System.out.println(result.getForPath() + " - " + result.getType());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 释放客户端连接
//            CloseableUtils.closeQuietly(cf);
//        }

//        Curator提供了三种Watcher(Cache)来监听结点的变化：
//
//        Path Cache：监视一个路径下1）孩子结点的创建、2）删除，3）以及结点数据的更新。产生的事件会传递给注册的PathChildrenCacheListener。
//        Node Cache：监视一个结点的创建、更新、删除，并将结点的数据缓存在本地。
//        Tree Cache：Path Cache和Node Cache的“合体”，监视路径下的创建、更新、删除事件，并缓存路径下所有孩子结点的数据。
//          ExecutorService pool = Executors.newFixedThreadPool(3);
//          final NodeCache nodeCache = new NodeCache(cf, "/myNodeListen/code", false);
//          nodeCache.start(true);
//        /**
//         * 监听数据节点的变化情况
//         */
//        nodeCache.getListenable().addListener(
//                  new NodeCacheListener() {
//                      @Override
//                      public void nodeChanged() throws Exception {
//                          System.out.println("node data is changed,new data:"+
//                                  new String(nodeCache.getCurrentData().getData()) );
//                      }
//                  },pool
//          );
//        /**
//         * 监听子节点的变化情况
//         */
//        final PathChildrenCache pathChildrenCache = new PathChildrenCache(cf, "/myNodeListen", true);
//        pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
//        pathChildrenCache.getListenable().addListener(
//                new PathChildrenCacheListener() {
//                    @Override
//                    public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
//                        switch (event.getType()){
//                            case CHILD_ADDED:
//                                System.out.println("CHILD_ADDED:" +event.getData().getPath());
//                                break;
//                            case CHILD_REMOVED:
//                                System.out.println("CHILD_REMOVED:" +event.getData().getPath());
//                                break;
//                            case CHILD_UPDATED:
//                                System.out.println("CHILD_UPDATED:" +event.getData().getPath());
//                                break;
//                            default:
//                                break;
//                        }
//                    }
//                },pool
//        );
//        cf.create().forPath("/myNodeListen/code");
//        cf.setData().forPath("/myNodeListen/code","halloworld".getBytes());
//        cf.create().forPath("/myNodeListen/myNode");
//        cf.delete().forPath("/myNodeListen/myNode");
//        TimeUnit.SECONDS.sleep(10);
//        pool.shutdown();
//        cf.close();


//        分布式编程时，比如最容易碰到的情况就是应用程序在线上多机部署，于是当多个应用同时访问某一资源时，就需要某种机制去协调它们。例如，现在一台应用正在rebuild缓存内容，要临时锁住某个区域暂时不让访问；又比如调度程序每次只想一个任务被一台应用执行等等。
//        下面的程序会启动两个线程t1和t2去争夺锁，拿到锁的线程会占用5秒。运行多次可以观察到，有时是t1先拿到锁而t2等待，有时又会反过来。Curator会用我们提供的lock路径的结点作为全局锁，这个结点的数据类似这种格式：[_c_64e0811f-9475-44ca-aa36-c1db65ae5350-lock-0000000005]，每次获得锁时会生成这种串，释放锁时清空数据。
//        new Thread(()->{
//              doWithLock(cf);
//        }).start();
//        new Thread(()->{
//            doWithLock(cf);
//        }).start();


//         Leader选举
//        当集群里的某个服务down机时，我们可能要从slave结点里选出一个作为新的master，这时就需要一套能在分布式环境中自动协调的Leader选举方法。Curator提供了LeaderSelector监听器实现Leader选举功能。同一时刻，只有一个Listener会进入takeLeadership()方法，说明它是当前的Leader。注意：当Listener从takeLeadership()退出时就说明它放弃了“Leader身份”，这时Curator会利用Zookeeper再从剩余的Listener中选出一个新的Leader。autoRequeue()方法使放弃Leadership的Listener有机会重新获得Leadership，如果不设置的话放弃了的Listener是不会再变成Leader的。
        LeaderSelectorListener listener = new LeaderSelectorListener() {

            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {
                try {
                    System.out.println(Thread.currentThread().getName() + " take leadership!");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName() + " relinquish leadership!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {

            }
        };
        new Thread(()->{
            registerListener(listener,"localhost:2181");
        }).start();
        new Thread(()->{
            registerListener(listener,"localhost:2182");
        }).start();
        new Thread(()->{
            registerListener(listener,"localhost:2183");
        }).start();
        Thread.sleep(Integer.MAX_VALUE);
    }
    public static void doWithLock(CuratorFramework cf){
        InterProcessMutex lock = new InterProcessMutex(cf, "/myLock");
        try {
            if(lock.acquire(10*1000,TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName()+"hold lock");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"release lock");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void registerListener(LeaderSelectorListener leaderSelectorListener,String address){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
//        client.start();
//        client.delete().forPath("/Curatot");
        //2 通过工厂创建连接
        CuratorFramework cf = CuratorFrameworkFactory
                .builder()
                .connectString(address)
                .connectionTimeoutMs(CONNECTION_TIMEOUT)
                .sessionTimeoutMs(SESSION_TIMEOUT)
                .namespace("curator")
                .retryPolicy(retryPolicy)
                .build();
        //3 开启连接
        cf.start();
//        new EnsurePath("/myLeader").equals(cf.getZookeeperClient());
        cf.create().creatingParentContainersIfNeeded();
        LeaderSelector leaderSelector = new LeaderSelector(cf, "/myleader", leaderSelectorListener);
        leaderSelector.autoRequeue();
        leaderSelector.start();
    }
}
