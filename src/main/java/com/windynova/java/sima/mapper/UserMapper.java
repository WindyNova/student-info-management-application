package com.windynova.java.sima.mapper;

import com.windynova.java.sima.entity.User;

import java.util.List;

public interface UserMapper {

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