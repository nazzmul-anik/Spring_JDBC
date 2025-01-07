package org.anik;

import org.anik.dao.StudentDao;
import org.anik.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        Student student = new Student();
        student.setId(102);
        student.setName("Bushra");
        student.setCity("Goran");
        studentDao.insert(student);
    }
}
