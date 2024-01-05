package com.solr.entity;

import lombok.Data;


@Data
public class Emp {
    private String empno;
    private String ename;
    private String job;
    private String mgr;
    private String hiredate;
    private String sal;
    private String comm;
    private String cv;
    private String uuid;
    private String deptUuid;
}
