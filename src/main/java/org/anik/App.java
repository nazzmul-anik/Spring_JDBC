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
        student.setName("Zim");
        student.setCity("Khilgaon");
//        studentDao.insertObject(student);
//        studentDao.updateObject(student);
//        studentDao.deleteObject(student.getId());
        Student student1 = studentDao.getStudent(student.getId());
        System.out.println(student1);
    }
}
