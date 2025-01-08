package org.anik.dao;

import org.anik.entity.Student;

public interface StudentDao {
    public int insertOject(Student student);
    public int updateObject(Student student);
    public int deleteObject(int studentId);
}
