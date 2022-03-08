package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.mapper.ClassMapper;
import cn.edu.jit.wdnv.java.sims.model.Class;


import java.util.ArrayList;
import java.util.List;

public class ClassDao extends BaseDao{

    public List<Class> query_all_class() {
        List<Class> results = new ArrayList<>();
        try {
            results = getSqlSession().getMapper(ClassMapper.class).selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;

    }


    public int insert_class(String clno, String clname, String dno) { // 插入班级信息
        status=0;
        try {
            Class Class=new Class();
            Class.setClno(clno);
            Class.setClname(clname);
            Class.setDno(dno);
            status = getSqlSession().getMapper(ClassMapper.class).insert(Class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public int delete_class(String clno) { // 删除班级信息
        status=0;
        try{
        status = getSqlSession().getMapper(ClassMapper.class).deleteByPrimaryKey(clno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public int alter_class(String clno, String after_clno, String after_clname, String after_dno) {   // 修改班级信息
        status =0;
        try {
            Class Class=new Class();
            Class.setClno(after_clno);
            Class.setClname(after_clname);
            Class.setDno(after_dno);
            status = getSqlSession().getMapper(ClassMapper.class).updateByPrimaryKey(Class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
