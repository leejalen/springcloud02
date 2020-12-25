package com.example.redisdata2001.operationService.impl;

import com.example.redisdata2001.constants.MapConstant;
import com.example.redisdata2001.operationService.ValueOperationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/12/9
 */
@Component
@Slf4j
public class ValueOperationsServiceImpl implements ValueOperationsService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void setKeyValue(String key, String value) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        //设置键值对
        operations.set(key, value);
        log.info("设置的键值对为 key:{} value:{}", key, value);
    }

    @Override
    public Object getValue(String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        //获取键值对
        Object object = operations.get(key);
        log.info("获取的值为 value:{}", object);
        return object;

    }

    @Override
    public void testIncrement(Map<String, Object> map) {
        String key = (String)map.get(MapConstant.KEY);
        String value = (String)map.get(MapConstant.VALUE);
        String newValue = (String)map.get(MapConstant.NEW_VALUE);
        Long updateTime = (Long)map.get(MapConstant.UPDATE_TIME);
        Long expireTime = (Long)map.get(MapConstant.EXPIRE_TIME);
        TimeUnit timeUnit = TimeUnit.SECONDS;

        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        //测试设置键值对
        operations.set(key, value);
        operations.increment(key);
        log.info("获取使用increment方法之后的值：{}", operations.get(key));
    }

    @Override
    public void testKeyValue(Map<String, Object> map) {
        String key = (String)map.get(MapConstant.KEY);
        Integer value = (Integer) map.get(MapConstant.VALUE);
        String newValue = (String)map.get(MapConstant.NEW_VALUE);
        Long updateTime = (Long)map.get(MapConstant.UPDATE_TIME);
        Long expireTime = (Long)map.get(MapConstant.EXPIRE_TIME);
        TimeUnit timeUnit = TimeUnit.SECONDS;

        //测试设置键值对
        //setKeyValue(key, value);

        //测试获取键值对
        getValue(key);

        //测试自动销毁键值对
        expireValueByTime(key, newValue, expireTime, timeUnit);

        try {
            Thread.sleep(1000 * updateTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object valueObject1 = getValue(key);
        log.info("测试值是否消亡 {}", valueObject1);
    }

    public void expireValueByTime(String key, String value, long updateTime, TimeUnit timeUnit) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        //设置值自动消亡
        operations.set(key, value, updateTime, timeUnit);
    }
}
