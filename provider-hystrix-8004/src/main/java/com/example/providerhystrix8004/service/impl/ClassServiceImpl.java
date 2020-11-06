package com.example.providerhystrix8004.service.impl;

import com.example.providerhystrix8004.dao.entity.SpClassDO;
import com.example.providerhystrix8004.dao.mapper.SpClassMapper;
import com.example.providerhystrix8004.service.IClassService;
import com.example.providerhystrix8004.service.bo.SpClassBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2020/10/31
 *
 * @author: leejalen
 */
@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    private SpClassMapper classMapper;

    @Override
    public void insertClass(SpClassDO spClassDO) {

    }

    @Override
    public void deleteClass(String classId) {

    }

    @Override
    public void updateClass(String classId) {

    }

    @Override
    public SpClassBO selectClass(String classId) {
        SpClassDO classDO = classMapper.select(classId);
        if (classDO == null){
            return null;
        }
        SpClassBO classBO = new SpClassBO();
        BeanUtils.copyProperties(classDO, classBO);
        return classBO;
    }
}
