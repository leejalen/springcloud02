package com.example.provider8001.dao.mapper;

import com.example.provider8001.dao.entity.SpSchoolDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author admin
 * */
@Mapper
public interface SpSchoolMapper {

    int delete(String schoolId);

    int insert(SpSchoolDO record);

    SpSchoolDO select(String schoolId);

    int update(SpSchoolDO record);
}