package com.windynova.java.sima.entity;

import lombok.Data;


@Data

public class CourseRanking {

    private Integer sNo;//学号
    private String dName;//系名
    private String clName;//班名
    private String sName;//学生姓名
    private String sSex;//学生性别
    private byte sAge;//学生年龄
    private short grade;//成绩
}

