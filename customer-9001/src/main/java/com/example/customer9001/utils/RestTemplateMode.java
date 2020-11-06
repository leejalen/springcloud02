package com.example.customer9001.utils;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 2020/11/5
 * @author leejalen
 */
@Configuration
public class RestTemplateMode {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
/*
    *//**
     * Ribbon算法1: 轮询
     * *//*
    @Bean
    public IRule myRoundRobinRule(){
        return new RoundRobinRule();
    }

    *//**
     * Ribbon算法2: 随机
     * *//*
    @Bean
    public IRule myRandomRule(){
        return new RandomRule();
    }

    *//**
     * Ribbon算法3: 过滤轮询
     * 先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务进行轮询
     * *//*
    @Bean
    public IRule myAvailabilityFilteringRule(){
        return new AvailabilityFilteringRule();
    }

    *//**
     * Ribbon算法4: 响应权重式轮询
     * 根据平均响应时间计算服务的权重。统计信息不足时会按照轮询，统计信息足够会按照响应的时间选择服务
     * *//*
    @Bean
    public IRule myWeightedResponseTimeRule(){
        return new WeightedResponseTimeRule();
    }

    *//**
     * Ribbon算法5: 跳过式轮询
     * 正常时按照轮询选择服务，若过程中有服务出现故障，在轮询一定次数后依然故障，则会跳过故障的服务继续轮询。
     * *//*
    @Bean
    public IRule myRetryRule(){
        return new RetryRule();
    }

    *//**
     * Ribbon算法6:
     * 先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
     * *//*
    @Bean
    public IRule myBestAvailableRule(){
        return new BestAvailableRule();
    }

    *//**
     * Ribbon算法7: 性能最优
     * 默认规则，符合判断server所在的区域的性能和server的可用性选择服务
     * *//*
    @Bean
    public IRule myZoneAvoidanceRule(){
        return new ZoneAvoidanceRule();
    }*/

}
