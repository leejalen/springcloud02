package com.example.provider8001.service;

import com.example.provider8001.dao.entity.SpClassDO;
import com.example.provider8001.service.bo.SpClassBO;

/**
 * Created on 2020/10/31
 * @author: leejalen
 */
public interface IClassService {

    void insertClass(SpClassDO spClassDO);

    void deleteClass(String classId);

    void updateClass(String classId);

    SpClassBO selectClass(String classId);
}
