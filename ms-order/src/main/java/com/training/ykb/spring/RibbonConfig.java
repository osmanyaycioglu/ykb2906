package com.training.ykb.spring;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;

public class RibbonConfig {

    @Bean
    public IRule myRule() {
        return new AvailabilityFilteringRule();
    }

    @Bean
    public IPing myPing() {
        return new NoOpPing();
    }

}
