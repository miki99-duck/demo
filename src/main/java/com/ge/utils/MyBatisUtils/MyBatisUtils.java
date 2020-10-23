package com.ge.utils.MyBatisUtils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static  SqlSessionFactory factory=null;
    static {
        //获取mybatis的主配置文件名称
        String config="mybatis.xml";
        try {
            InputStream in= Resources.getResourceAsStream(config);
            //创建sqlSessionFactoryBuilder对象
            factory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if( factory!=null){
            //非自动提交事务
            sqlSession=factory.openSession();
        }
        return sqlSession;
    }
}
