package com.example.provider8001.dao.mapper;

import com.example.provider8001.dao.entity.SpClassDO;
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