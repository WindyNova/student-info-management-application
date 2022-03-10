package cn.edu.jit.wdnv.java.sims.beans;

import lombok.Data;

@Data

public class Course_fail_rate{

    private Integer Cno;//课程号
    private String Cname;//课程名称
    private String Cteacher;//执教老师
    private byte Ccredit;//学分
    private float failRate;//不及格率


}
