package com.ge;


import com.ge.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    //查询操作
    public static void main(String[] args) throws IOException {
        //获取配置文件
        String config="mybatis.xml";
        //读取配置文件
        InputStream inputStream= org.apache.ibatis.io.Resources.getResourceAsStream(config);
        //
        SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
        SqlSessionFactory sf=sfb.build(inputStream);
        SqlSession sqlSession=sf.openSession();
        //映射sql文件 namespace id
        String sqlId="com.ge.dao.StudentDao.insertStudent";
        //创建对象
        Student student=new Student();
        student.setId(1004);
        student.setName("王伟");

        //执行sql 语句
        int tot=sqlSession.insert(sqlId,student);
        //输出插入的数量
        //要是想看到插入的数据是什么，必须要配置日志文件
        //在mybatis.xml文件中
        System.out.println("插入的数量："+tot);
        //myBatis默认不提交事务，手动提交
        sqlSession.commit();
    }
}
