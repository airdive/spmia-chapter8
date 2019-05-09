package com.thoughtmechanix.organization.config;

import com.thoughtmechanix.organization.events.CustomPartitionKeyExtractor;
import com.thoughtmechanix.organization.events.CustomPartitionSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Author: liuchuang
 * @Date: 2019-05-09 11:02
 */
@Configuration
public class KafkaBindingConfig {

    @Bean
    public CustomPartitionKeyExtractor customPartitionKeyExtractor() {
        return new CustomPartitionKeyExtractor();
    }

    @Bean
    public CustomPartitionSelector customPartitionSelector() {
        return new CustomPartitionSelector();
    }

}
