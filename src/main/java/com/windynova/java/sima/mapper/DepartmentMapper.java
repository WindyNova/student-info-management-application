package com.windynova.java.sima.mapper;

import com.windynova.java.sima.entity.Department;

import java.util.List;

public interface DepartmentMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String dno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Department row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Department selectByPrimaryKey(String dno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Department> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Department row);
}