package com.windynova.java.sima.mapper;

import com.windynova.java.sima.entity.Class;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ClassMapper {

@Select("select * from class order by clno")
    List<Class> queryAllClass();

    @Delete("delete from class where clno= #{clno}")
    void deleteClass(Integer clno);

@Insert("insert into class values(#{clno},#{clname},#{dno})")
    void insertClass(Integer clno, String clname, Integer dno);


@Update("update class set clno = #{new_clno},clname = #{clname},dno = #{dno} where clno = #{clno}")
    void updateClass(Integer new_clno, String clname, Integer dno,Integer clno);




}