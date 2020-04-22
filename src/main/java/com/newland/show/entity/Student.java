package com.newland.show.entity;

import javax.persistence.*;
import java.util.Date;

/***
 * 用户
 *
 * @author zhengfawei
 */
@Entity
@Table(name = "T_STUDENT")
public class Student {
    /***
     * ID(主键) 学生编号，标识唯一学生
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Integer studentId;

    /***
     * 学生名称
     */
    @Column(name = "STUDENT_NAME")
    private String studentName;

    /***
     * 学生年龄
     */
    @Column(name = "STUDENT_AGE")
    private Integer studentAge;

    /***
     * 更新时间
     */
    @Column(name = "UPD_TIME")
    private Date updTime;

    /***
     * 更新时间
     */
    @Column(name = "CRT_TIME")
    private Date crtTime;

    /**
     * getter method
     */
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}
