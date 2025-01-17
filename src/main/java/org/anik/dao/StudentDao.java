package org.anik.dao;

import org.anik.entity.Student;

import java.util.List;

public interface StudentDao {
    public int insertObject(Student student);
    public int updateObject(Student student);
    public int deleteObject(int studentId);
    public Student getStudent(int studentId);
    public List<Student> getAllStudents();
}
