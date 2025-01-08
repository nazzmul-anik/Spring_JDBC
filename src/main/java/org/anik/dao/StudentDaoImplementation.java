package org.anik.dao;

import org.anik.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImplementation implements StudentDao{

    private JdbcTemplate jdbcTemplate;
    @Override
    public int insertOject(Student student) {
        String query = "insert into student(id, name, city) values (?, ?, ?)";
        int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return result;
    }

    @Override
    public int updateObject(Student student) {
        String updateQuery = "update student set name = ?, city = ? where id = ?";
        int result = this.jdbcTemplate.update(updateQuery, student.getName(), student.getCity(), student.getId());
        return result;
    }

    @Override
    public int deleteObject(int studentId) {
        String deleteQuery = "delete from student where id = ?";
        int result = this.jdbcTemplate.update(deleteQuery, studentId);
        return result;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



}
