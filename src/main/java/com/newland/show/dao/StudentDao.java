package com.newland.show.dao;



import com.newland.show.config.HibernateBaseDao;
import com.newland.show.entity.Student;

import java.util.List;

public interface StudentDao {
    /***
     * 查询全部学生
     */
    public  List<Student> findAll();
   public Student findStudentById();
    /***
     * 增加学生
     */

    public void saveStudent(Student student);
//    /***
//     * 更新学生
//     */
    public void updateStudent(Integer studentId);
//    /***
//     * 根据学生Id删除学生
//     */
    public void deleteStudentByStudent(Integer studentId);
//    /***
//     * 根据学生姓名查询学生
//     */
//    public Student findStudentByStudentName(String studentName);
}
