package cn.edu.jit.wdnv.java.sims.mapper;

import cn.edu.jit.wdnv.java.sims.model.Class;
import java.util.List;

public interface ClassMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String clno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Class row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Class selectByPrimaryKey(String clno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Class> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Class row);
}