package cn.edu.jit.wdnv.java.sims.mapper;

import cn.edu.jit.wdnv.java.sims.beans.User;
import java.util.List;

public interface UserMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String username);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(User row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    User selectByPrimaryKey(String username);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<User> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(User row);
}