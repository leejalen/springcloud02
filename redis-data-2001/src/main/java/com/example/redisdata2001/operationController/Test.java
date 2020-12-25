package com.example.redisdata2001.operationController;

import com.example.redisdata2001.constants.MapConstant;
import com.example.redisdata2001.operationService.ValueOperationsService;
import com.example.redisdata2001.operationService.impl.ValueOperationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/25
 * @Description
 */
public class Test {


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(5);
        map.put(MapConstant.KEY, "key1");
        map.put(MapConstant.VALUE, "value1");
        map.put(MapConstant.NEW_VALUE, "newValue1");
        map.put(MapConstant.UPDATE_TIME, 5L);
        map.put(MapConstant.EXPIRE_TIME, 5L);
        Test test = new Test();
        ValueOperationsService operation = new ValueOperationsServiceImpl();
        operation.testKeyValue(map);
        System.out.println("1");
    }
}
