package com.windynova.java.sima.service.impl;

import com.windynova.java.sima.mapper.ClassMapper;
import com.windynova.java.sima.entity.Class;
import com.windynova.java.sima.service.ClassService;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class ClassServiceImpl implements ClassService {

    @Resource
ClassMapper Class;

    @Override
    public List<Class> queryAllClass() {
return Class.queryAllClass();

    }

@Override
    public void insertClass(Integer clno, String clname, Integer dno) { // 插入班级信息
        Class.insertClass(clno,clname,dno);

    }

@Override
    public void deleteClass(Integer clno) { // 删除班级信息
Class.deleteClass(clno);
    }

@Override
    public void updateClass(Integer new_clno, String clname, Integer dno,Integer clno) {   // 修改班级信息

            Class.updateClass(new_clno,clname,dno,clno);
}
