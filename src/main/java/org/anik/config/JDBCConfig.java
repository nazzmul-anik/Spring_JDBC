package org.anik.config;

import org.anik.dao.StudentDao;
import org.anik.dao.StudentDaoImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//Without XML file configuration setup

@Configuration
public class JDBCConfig {
    @Bean("ds")
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean("studentDao")
    public StudentDao getStudentDao(){
        StudentDaoImplementation studentDao = new StudentDaoImplementation();
        studentDao.setJdbcTemplate(getTemplate());
        return studentDao;
    }

}

