package com.example.redisdata2001.operationController;

import com.example.redisdata2001.constants.MapConstant;
import com.example.redisdata2001.operationService.ValueOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/12/9
 */
@RestController
public class ValueOperationsController {

    @Autowired
    private ValueOperationsService valueOperationsService;

    @RequestMapping("/test")
    public void test(){
        Map<String, Object> map = new HashMap<>(5);
        map.put(MapConstant.KEY, "key1");
        map.put(MapConstant.VALUE, "value1");
        map.put(MapConstant.NEW_VALUE, "newValue1");
        map.put(MapConstant.UPDATE_TIME, 5L);
        map.put(MapConstant.EXPIRE_TIME, 5L);
        valueOperationsService.testKeyValue(map);
    }

    @RequestMapping("/increment")
    public void testIncrement(){
        Map<String, Object> map = new HashMap<>(5);
        map.put(MapConstant.KEY, "key1");
        map.put(MapConstant.VALUE, "5");
        map.put(MapConstant.NEW_VALUE, "newValue1");
        map.put(MapConstant.UPDATE_TIME, 5L);
        map.put(MapConstant.EXPIRE_TIME, 5L);
        valueOperationsService.testIncrement(map);
    }

    @RequestMapping("/increment/{delta}")
    public void testIncrement(@PathVariable("delta") double delta){
        Map<String, Object> map = new HashMap<>(5);
        map.put(MapConstant.KEY, "key1");
        map.put(MapConstant.VALUE, "5");
        map.put(MapConstant.NEW_VALUE, "newValue1");
        map.put(MapConstant.UPDATE_TIME, 5L);
        map.put(MapConstant.EXPIRE_TIME, 5L);
        valueOperationsService.testIncrement(map, delta);
    }

    @RequestMapping("/decrement")
    public void testDecrement(){
        Map<String, Object> map = new HashMap<>(5);
        map.put(MapConstant.KEY, "key1");
        map.put(MapConstant.VALUE, "5");
        map.put(MapConstant.NEW_VALUE, "newValue1");
        map.put(MapConstant.UPDATE_TIME, 5L);
        map.put(MapConstant.EXPIRE_TIME, 5L);
        valueOperationsService.testDecrement(map);
    }
}
