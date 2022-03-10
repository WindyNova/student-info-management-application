package cn.edu.jit.wdnv.java.sims.mapper;

import cn.edu.jit.wdnv.java.sims.beans.Student;
import java.util.List;

public interface StudentMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Student row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Student selectByPrimaryKey(String sno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Student> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Student row);
}