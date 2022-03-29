package com.windynova.java.sima.entity;

import lombok.Data;

@Data
public class Course {
    private Integer cNo;

    private String cName;

    private String cTeacher;

    private byte cCredit;
}