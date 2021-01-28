package com.example.redisdata2001.operationService;

import java.util.List;
import java.util.Map;
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
    void testKeyValue(Map<String, Object> map);

    /**
     * 设置键值对
     * @param key
     * @param value
     * */
    void setKeyValue(String key, String value);

    /**
     * 根据键获取值
     * @param key
     * @return
     * */
    Object getValue(String key);

    /**
     * 每调用一次increment方法，以字符类型存储的数字的值都将加1
     * @param map
     * */
    void testIncrement(Map<String, Object> map);

    /**
     * 每调用一次increment方法，以字符类型存储的数字的值都将加delta
     * @param map
     * */
    void testIncrement(Map<String, Object> map, long delta);

    /**
     * 每调用一次increment方法，以字符类型存储的数字的值都将加delta
     * @param map
     * */
    void testIncrement(Map<String, Object> map, double delta);

    /**
     * 每调用一次increment方法，以字符类型存储的数字的值都将减1
     * @param map
     * */
    void testDecrement(Map<String, Object> map);

    List<String> getKeys();
}
