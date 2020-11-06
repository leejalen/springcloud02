package com.example.providerhystrix8004.dao.mapper;

import com.example.providerhystrix8004.dao.entity.SpSchoolDO;
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