package com.example.threadpool1001.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/12/8
 */
@Configuration
@EnableAsync
public class TaskPoolConfig {

    @Autowired
    private ThreadPoolConfig threadPoolConfig;

    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        taskExecutor.setCorePoolSize(threadPoolConfig.getCorePoolSize());
        //设置最大线程数
        taskExecutor.setMaxPoolSize(threadPoolConfig.getMaxPoolSize());
        //设置队列容量
        taskExecutor.setQueueCapacity(threadPoolConfig.getQueueCapacity());
        //设置允许的空闲时间（秒）
        taskExecutor.setKeepAliveSeconds(threadPoolConfig.getKeepAliveSeconds());
        //设置默认线程名称
        taskExecutor.setThreadNamePrefix(threadPoolConfig.getThreadNamePrefix());
        //是否等待所有任务结束后再关闭线程池
        taskExecutor.setWaitForTasksToCompleteOnShutdown(threadPoolConfig.isWaitForTasksToCompleteOnShutdown());
        /**
         * 当线程池缓存队列已满，且线程数达到maxsize，还有新任务到来时，所采取的策略
         * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常（默认策略）
         * ThreadPoolExecutor.DiscardPolicy:也是丢弃任务，但是不抛出异常
         * ThreadPoolExecutor.DiscardOldestPolicy:丢弃队列最前面的任务，然后重新尝试执行任务
         * ThreadPoolExecutor.CallerRunsPolicy:由调用线程处理该任务
         * */
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return taskExecutor;
    }
}
