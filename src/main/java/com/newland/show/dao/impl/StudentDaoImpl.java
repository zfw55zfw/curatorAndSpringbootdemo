package com.newland.show.dao.impl;



import com.newland.show.dao.StudentDao;
import com.newland.show.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * @author lcfut
 */
@Repository
public class StudentDaoImpl implements StudentDao {

//    @Resource
//    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

//    @PersistenceContext
//    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {
        String jpql="select s from Student s ";
        Query query = entityManager.createQuery(jpql);
        List<Student> list= query.getResultList();
        return list;
    }

    @Override
    @Transactional
    public Student findStudentById() {
        //Session session = sessionFactory.openSession();
//        Session session = sessionFactory.getCurrentSession();
//
//        String hql="from "+Student.class.getName()+" s ";
//        Query query = session.createQuery(hql);
//        List<Student> list= query.list();
        Student student = entityManager.find(Student.class, 22);

        return student;
    }



    @Override
    @Transactional
    public void saveStudent(Student student) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(student);
//        String hql="from "+Student.class.getName()+" s ";
//        Query query = session.createQuery(hql);
//        List<Student> list= query.list();
//        return list;
//        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void updateStudent(Integer studentId) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(student);
//        String hql="from "+Student.class.getName()+" s ";
//        Query query = session.createQuery(hql);
//        List<Student> list= query.list();
//        return list;
        Student updstudent = entityManager.find(Student.class, studentId);
        updstudent.setStudentName("aaaa");


    }

    @Override
    @Transactional
    public void deleteStudentByStudent(Integer studentId) {
//        Session session = sessionFactory.getCurrentSession();
//        Student student =new Student();
//        student.setStudentId(22);
//        session.delete(student);
//
//        String hql="from "+Student.class.getName()+" s ";
//        Query query = session.createQuery(hql);
//        List<Student> list= query.list();
//        return list;
        Student delstudent = entityManager.find(Student.class, studentId);
        entityManager.remove(delstudent);
    }
//
//    @Override
//    @Transactional
//    public Student findStudentByStudentName(String studentName) {
//        Session session = sessionFactory.getCurrentSession();
//        String hql="from "+Student.class.getName()+" s where s.studentName='"+studentName+"'";
//        Query query = session.createQuery(hql);
//        List<Student> list= query.list();
//        if (list.size()>0){
//            Student studnet=list.get(0);
//            return studnet;
//        }
//        return null;
//    }
}
