package com.thoughtmechanix.organization.events;

import org.springframework.cloud.stream.binder.PartitionSelectorStrategy;
import org.springframework.util.ObjectUtils;

/**
 * @Description: 决定message发送到哪个partition的策略
 * @Author: liuchuang
 * @Date: 2019-05-09 10:56
 */
public class CustomPartitionSelector implements PartitionSelectorStrategy {
    @Override
    public int selectPartition(Object key, int partitionCount) {
        System.out.println("消息载荷的key：" + key + " partitionCount：" + partitionCount);

        if (!ObjectUtils.isEmpty(key)) {
            return key.hashCode() % partitionCount;
        }

        return 0;
    }
}
