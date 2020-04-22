package com.show.zookeeper.curator;

import sun.tools.tree.ThisExpression;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengfawei
 * @create 2020-04-17 下午4:55
 * @desc
 **/
public class MyThreadCallable implements Callable {
    int id;
    public MyThreadCallable(int id) {
        this.id=id;
    }

    @Override
    public Object call() throws Exception {
        Random random = new Random();
        TimeUnit.SECONDS.sleep(random.nextInt(10));
        return id;
    }
}
