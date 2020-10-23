package com.ge.dao;

import com.ge.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//接口操作Student表
public interface StudentDao {

// 查询student表的所有数据
     List<Student> selectStudents();

    //插入操作
    int insertStudent(Student student);

    //多个参数查询操作 @Param("")
  List<Student> selectStudent(@Param("MyId") Integer id,@Param("MyName") String name);
}
