package cn.edu.jit.wdnv.java.sims.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String username;//用户名
    private String password;//密码
    private String level;//权限级别


}
