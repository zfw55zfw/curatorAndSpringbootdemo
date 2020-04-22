package com.newland.show.service;




import com.newland.show.entity.Student;

import java.util.List;

public interface StudentService {
    /***
     * 查询全部学生
     */
    public List<Student> findAll();
    public Student findStudentById();
    /***
     * 根据学生Id删除学生
     */
    public void deleteStudentByStudentId(Integer studentId);
    /***
     * 根据学生姓名查询学生
     */
//    public Student findStudentByStudentName(String studentName);
    /***
     * 增加学生
     */
    public void saveStudent(Student student);
    /***
     * 更新学生
     */
    public void updateStudent(Integer studentId);
}
