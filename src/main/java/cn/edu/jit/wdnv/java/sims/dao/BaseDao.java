package cn.edu.jit.wdnv.java.sims.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public abstract class BaseDao {
    static int status = 0;
    static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            String environment = "development";

            InputStream inputStream = Resources.getResourceAsStream(resource);

            //2 创建一个工厂，完成对配置文件的读取
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, environment); //Polymorphism??????
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //既然有了 SqlSessionFactory，顾名思义，我们就可以从中获得 SqlSession 的实例了
    // SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法
    SqlSession getSqlSession() {
        //3 创建sqlSession，开启工厂
        return sqlSessionFactory.openSession();
    }
}
