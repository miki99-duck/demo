package com.ge;

import com.ge.dao.StudentDao;
import com.ge.domain.Student;
import com.ge.utils.MyBatisUtils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    //查询方法
    @o.Test
    public void testSelect(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        //com.sun.proxy.$Proxy2:jdk的动态代理
        System.out.println("dao="+dao.getClass().getName());
        //调用dao()方法执行数据的操作
        List<Student> students=dao.selectStudents();
        for (Student stu:students
             ) {
            System.out.println("信息=："+stu);
        }
    }
@org.junit.Test
    public void insertStudent(){
SqlSession sqlSession=MyBatisUtils.getSqlSession();
StudentDao dao=sqlSession.getMapper(StudentDao.class);
        System.out.println("dao="+dao.getClass().getName());
   Student student=new Student();
   student.setId(1010);
   student.setName("tom");
   int nums=dao.insertStudent(student);
   sqlSession.commit();
        System.out.println("添加对象的数量："+nums);
    }

}
