package com.example.providerhystrix8004.service;

import com.example.providerhystrix8004.dao.entity.SpClassDO;
import com.example.providerhystrix8004.service.bo.SpClassBO;

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
