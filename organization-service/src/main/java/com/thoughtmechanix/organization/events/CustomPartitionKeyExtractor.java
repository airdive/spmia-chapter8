package com.thoughtmechanix.organization.events;

import com.thoughtmechanix.organization.events.models.OrganizationChangeModel;
import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.messaging.Message;

/**
 * @Description: 从Message中提取partition key的策略
 * @Author: liuchuang
 * @Date: 2019-05-09 10:49
 */
public class CustomPartitionKeyExtractor implements PartitionKeyExtractorStrategy {

    @Override
    public Object extractKey(Message<?> message) {
        Object obj = message.getPayload();
        System.out.println("消息载荷：" + obj);
        if (obj instanceof OrganizationChangeModel){
            OrganizationChangeModel org = (OrganizationChangeModel) obj;
            return org.getOrganizationId();
        }

        return null;
    }
}
