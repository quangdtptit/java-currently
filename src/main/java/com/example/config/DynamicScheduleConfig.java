package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Configuration
public class DynamicScheduleConfig {

    @Value("${dynamic.schedule.count}")
    private Integer threadCount;

    @Bean
    public ScheduledThreadPoolExecutor initScheduledThreadPoolExecutor() {
        return (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(threadCount);
    }
}
