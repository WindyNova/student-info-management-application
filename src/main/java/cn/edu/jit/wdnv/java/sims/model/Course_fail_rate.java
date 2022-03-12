package cn.edu.jit.wdnv.java.sims.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course_fail_rate {

    private Integer Cno;//课程号
    private String Cname;//课程名称
    private String Cteacher;//执教老师
    private byte Ccredit;//学分
    private float fail_rate;//不及格率


}
