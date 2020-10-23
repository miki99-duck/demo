package com.ge;

import com.ge.domain.Student;
import com.ge.utils.MyBatisUtils.MyBatisUtils;

import org.apache.ibatis.session.SqlSession;



import java.util.List;

public class MyTest2 {
    public static void main(String[] args) {
       SqlSession sqlSession= MyBatisUtils.getSqlSession();
        //6.(重要)指定要执行的sql语句的标识，
        //sql映射文件中的namespaces+ “.”+标签的id值
        //无参数查询
        String sqlId1="com.ge.dao.StudentDao.selectStudents";
        //多个参数查询
        String sqlId2="com.ge.dao.StudentDao.selectStudent";
        //7.执行sql语句，通过sqlId找到语句
        List<Student> studentList2=sqlSession.selectList(sqlId1);
        //8.输出结果
        for (Student s:studentList2
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
