package com.newland.show.service.impl;




import com.newland.show.dao.StudentDao;
import com.newland.show.entity.Student;
import com.newland.show.service.StudentService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.util.List;


/**
 * @author lcfut
 */

@Repository
@EnableAutoConfiguration
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;


    @Override
    public List<Student> findAll() {
       return studentDao.findAll();
    }

    @Override
    public Student findStudentById() {
        return studentDao.findStudentById();
    }


    @Override
    public void deleteStudentByStudentId(Integer studentId) {

        studentDao.deleteStudentByStudent(studentId);
    }

//    @Override
//    public Student findStudentByStudentName(String studentName) {
//        return studentDao.findStudentByStudentName(studentName);
//    }

    @Override
    public void saveStudent(Student student) {
         studentDao.saveStudent(student);
    }

    @Override
    public void updateStudent(Integer studentId) {
        studentDao.updateStudent(studentId);
    }
}
