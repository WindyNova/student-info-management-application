package cn.edu.jit.wdnv.java.sims.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private Integer Sno;//学号
    private String Sname;//姓名
    private String Ssex;//性别
    private byte Sage;//年龄
    private Integer Clno;//所在班级


}
