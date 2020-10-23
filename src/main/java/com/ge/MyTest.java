package com.ge;

import com.ge.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    public static void main(String[] args) throws IOException {
        //访问mybatis，访问student数据
        //先编译为classes文件，mybatis启动会先从target/classes查找
        //1.定义mabatis主配置文件
        String config="mybatis.xml";
        //2.读取配置文件
        InputStream in=Resources.getResourceAsStream(config);
        //3创建sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //4.创建sqlsessionFactory对象
        SqlSessionFactory factory=builder.build(in);
        //5.(重要)获取sqlsession对象，从sqlsessionFactory中
        //获取sqlsession
        //openSession()默认为false:表示不自动提交事务，true：自动提交
        SqlSession sqlSession=factory.openSession();
        //6.(重要)指定要执行的sql语句的标识，
        //sql映射文件中的namespaces+ “.”+标签的id值
        String sqlId="com.ge.dao.StudentDao.selectStudents";
        //7.执行sql语句，通过sqlId找到语句
        List<Student> studentList=sqlSession.selectList(sqlId);
        //8.输出结果
        for (Student s:studentList
             ) {
//            String filePath = "D:\\123.txt";
//            FileWriter fw = new FileWriter(filePath, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            bw.write(String.valueOf(s));
//            bw.close();
//            fw.close();
            System.out.println("查询结果"+s);
        }
        //关闭sqlsession对象
        sqlSession.close();

    }
}
