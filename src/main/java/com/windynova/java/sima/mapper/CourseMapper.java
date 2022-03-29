package com.windynova.java.sima.mapper;

import com.windynova.java.sima.entity.Course;

import java.util.List;

public interface CourseMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String cno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Course row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Course selectByPrimaryKey(String cno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Course> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Course row);
}