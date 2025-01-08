package org.anik.dao;

import org.anik.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImplementation implements StudentDao{

    private JdbcTemplate jdbcTemplate;
    @Override
    public int insertObject(Student student) {
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

    @Override
    public Student getStudent(int studentId) {
        String query = "select *from student where id = ?";
        RowMapper<Student> rowMapper = new RowMapperImplementation();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select *from student";
        List<Student> studentList = this.jdbcTemplate.query(query, new RowMapperImplementation());
        return studentList;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



}
