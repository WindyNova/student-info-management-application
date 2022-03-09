package cn.edu.jit.wdnv.java.sims.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SC {


    private Integer Sno;//学号
    private String Sname;//姓名
    private String Ssex;//性别
    private byte Sage;//年龄
    private Integer Cno;//课程号
    private String Cname;//课程名称
    private float Grade;//成绩


}
