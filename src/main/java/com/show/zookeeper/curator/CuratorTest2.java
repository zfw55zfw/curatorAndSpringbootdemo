package com.show.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.transaction.CuratorOp;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengfawei
 * @create 2020-04-17 下午2:54
 * @desc
 **/
public class CuratorTest2 {
    //会话超时时间
    private static final int SESSION_TIMEOUT = 30 * 1000;

    //连接超时时间
    private static final int CONNECTION_TIMEOUT = 3 * 1000;

    //ZooKeeper服务地址
    private static final String CONNECT_ADDR = "localhost:2183";

    public static void main(String[] args) throws Exception {
        //1 重试策略：初试时间为1s 重试10次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
//        client.start();
//        client.delete().forPath("/Curatot");
        //2 通过工厂创建连接
        CuratorFramework cf = CuratorFrameworkFactory
                .builder()
                .connectString(CONNECT_ADDR)
                .connectionTimeoutMs(CONNECTION_TIMEOUT)
                .sessionTimeoutMs(SESSION_TIMEOUT)
//                .namespace("curator")
                .retryPolicy(retryPolicy)
                .build();
        //3 开启连接
        cf.start();
        //创建永久节点
//        cf.create()
//          .forPath("/PERSISTENT_TEST3","PERSISTENT DATA".getBytes());
//        //创建永久有序节点
//        cf.create()
//          .withMode(CreateMode.PERSISTENT_SEQUENTIAL)
//          .forPath("/PERSISTENT_SEQUENTIAL_TEST3","PERSISTENT_SEQUENTIAL DATA".getBytes());
        //创建临时节点
//        cf.create()
//          .withMode(CreateMode.EPHEMERAL)
//          .forPath("/EPHEMERAL_TEST3","EPHEMERAL_TEST DATA".getBytes());
//        //创建临时有序节点
//        cf.create()
//          .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
//          .forPath("/EPHEMERAL_SEQUENTIAL_TEST3","EPHEMERAL_SEQUENTIAL_TEST DATA".getBytes());
//        //测试检查某个节点是否存在
//        new Thread(()->{
//            try {
//                while (true){
//                    Stat stat = cf.checkExists().forPath("/PERSISTENT_TEST2");
//                    Stat stat1 = cf.checkExists().forPath("/EPHEMERAL_TEST2");
//                    System.out.println("'/PERSISTENT_TEST2'是否存在： " + (stat != null ? true : false));
//                    System.out.println("'/EPHEMERAL_TEST2'是否存在： " + (stat1 != null ? true : false));
//                    TimeUnit.SECONDS.sleep(5);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();

        //获取某个节点数据
//        System.out.println(new String(cf.getData().forPath("/PERSISTENT_TEST3")));
//
//        //设置某个节点数据
//        cf.setData().forPath("/PERSISTENT_TEST3","/PERSISTENT_TEST3 modified data".getBytes());
//
//        System.out.println(new String(cf.getData().forPath("/PERSISTENT_TEST3")));

//        orSetData()方法：如果节点存在则Curator将会使用给出的数据设置这个节点的值，相当于 setData() 方法
//        creatingParentContainersIfNeeded()方法：如果指定节点的父节点不存在，则Curator将会自动级联创建父节点
//        guaranteed()方法：如果服务端可能删除成功，但是client没有接收到删除成功的提示，Curator将会在后台持续尝试删除该节点
//        deletingChildrenIfNeeded()方法：如果待删除节点存在子节点，则Curator将会级联删除该节点的子节点
        //创建测试节点

//         cf.create().orSetData().creatingParentContainersIfNeeded()
//             .forPath("/curator/del_key3","/curator/del_key3 data".getBytes());
//
//         cf.create().orSetData().creatingParentContainersIfNeeded()
//         .forPath("/curator/del_key3","/curator/del_key3 data".getBytes());
//
//         cf.create().forPath("/curator/del_key3/test_key","test_key data".getBytes());
//        Stat stat = cf.checkExists().forPath("/curator/del_key3");
//        System.out.println("'/curator/del_key3'是否存在： " + (stat != null ? true : false));
//
//        //删除该节点
//         cf.delete().forPath("/curator/del_key3");
//        Stat stat3 = cf.checkExists().forPath("/curator/del_key3");
//        System.out.println("'/curator/del_key3'是否存在： " + (stat3 != null ? true : false));

//         //级联删除子节点
//        cf.delete().guaranteed().deletingChildrenIfNeeded().forPath("/curator");


        /* 事务管理：碰到异常，事务会回滚
         * @throws Exception
         */
//            //定义几个基本操作
//            CuratorOp createOp = cf.transactionOp().create()
//                    .forPath("/curator/one_path","some data".getBytes());
//
//            CuratorOp setDataOp = cf.transactionOp().setData()
//                    .forPath("/curator","other data".getBytes());
//
//            CuratorOp deleteOp = cf.transactionOp().delete()
//                    .forPath("/curator");
//
//            //事务执行结果
//            List<CuratorTransactionResult> results = cf.transaction()
//                    .forOperations(createOp,setDataOp,deleteOp);
//
//            //遍历输出结果
//            for(CuratorTransactionResult result : results){
//                System.out.println("执行结果是： " + result.getForPath() + "--" + result.getType());
//            }
//因为节点“/curator”存在子节点，所以在删除的时候将会报错，事务回滚
    }
}
