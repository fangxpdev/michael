package com.fangxp.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * 使用curator实现分布式锁
 * 1、多节点会依次向各节点申请锁，N/2+1申请成功则申请锁成功，解锁需要对所有节点释放锁，无论是否加锁成功
 * 2、申请锁原理：
 * 每个客户端创建临时有序节点（znode），判断自己是否为最小序号节点，最小序号则申请锁成功，
 * 不为最小序号则监听前一个节点
 *
 */
public class ZkLockTest {

    public static void main(String[] args) throws Exception {
        //创建zookeeper的客户端
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.121:2181", retryPolicy);
        client.start();

        //创建分布式锁, 锁空间的根节点路径为/curator/lock
        InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");
        mutex.acquire();
        //获得了锁, 进行业务流程
        System.out.println("Enter mutex");
        //完成业务流程, 释放锁
        mutex.release();

        //关闭客户端
        client.close();

    }

}
