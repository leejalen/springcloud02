package com.example.providerhystrix8004.service.bo;

import lombok.Data;

import java.util.Date;

@Data
public class SpClassBO {

    private String classId;

    private String className;

    private String schoolId;

    private String status;

    private Date gmtCreate;

    private Date gmtModify;

}