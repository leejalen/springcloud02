package com.example.redisdata2001.operationService;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/12/9
 */
public interface ValueOperationsService {

    /**
     * 测试键值对的各个功能
     * @param map
     * */
    public void testKeyValue(Map<String, Object> map);

    /**
     * 设置键值对
     * @param key
     * @param value
     * */
    public void setKeyValue(String key, String value);

    /**
     * 获取值
     * @param key
     * @return
     * */
    public Object getValue(String key);

    /**
     * 测试increment方法
     * @param map
     * */
    public void testIncrement(Map<String, Object> map);
}
