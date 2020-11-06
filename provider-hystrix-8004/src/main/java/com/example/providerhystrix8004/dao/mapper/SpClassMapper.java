package com.example.providerhystrix8004.dao.mapper;

import com.example.providerhystrix8004.dao.entity.SpClassDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author admin
 * */
@Mapper
public interface SpClassMapper {

    int delete(String classId);

    int insert(SpClassDO record);

    SpClassDO select(String classId);

    int update(SpClassDO record);
}