package com.example.provider8002.dao.mapper;

import com.example.provider8002.dao.entity.SpCustomerDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author admin
 * */
@Mapper
public interface SpCustomerMapper {

    int delete(String customerId);

    int insert(SpCustomerDO record);

    SpCustomerDO select(String customerId);

    int update(SpCustomerDO record);
}