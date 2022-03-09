package cn.edu.jit.wdnv.java.sims.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course_ranking {

    private Integer Sno;//学号
    private String Dname;//系名
    private String Clname;//班名
    private String Sname;//学生姓名
    private String Ssex;//学生性别
    private byte Sage;//学生年龄
    private float Grade;//成绩

}
