import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by dandeac on 15/03/2017.
 */
public class DatabaseManagementTest {
    DatabaseManagement db;
    Student student = new Student(1,"Pop Marius",1995,"Cluj-Napoca");
    Course course = new Course(1,"math","teacher",3);




    @Test
    public void addStudentTest() throws Exception {
        Connection conn = db.getConnection();
        boolean testOutput=db.addStudent(conn,student);
        boolean expected=true;
        assertEquals(expected,testOutput);
    }

    @Test
    public void removeStudentTest() throws Exception {
        Connection conn = db.getConnection();
        boolean testOutput=db.removeStudent(conn,student);
        boolean expected=true;
        assertEquals(expected,testOutput);
    }

    @Test
    public void updateStudentTest() throws Exception {
        Connection conn = db.getConnection();
        boolean testOutput=db.updateStudent(conn,student);
        boolean expected=true;
        assertEquals(expected,testOutput);
    }

    @Test
    public void addCourseTest() throws Exception {
        Connection conn = db.getConnection();
        boolean testOutput=db.addCourse(conn,course);
        boolean expected=true;
        assertEquals(expected,testOutput);
    }

    @Test
    public void removeCourseTest() throws Exception {
        Connection conn = db.getConnection();
        boolean testOutput=db.removeCourse(conn,course);
        boolean expected=true;
        assertEquals(expected,testOutput);
    }

    @Test
    public void updateCourseTest() throws Exception {
        Connection conn = db.getConnection();
        boolean testOutput=db.updateCourse(conn,course);
        boolean expected=true;
        assertEquals(expected,testOutput);
    }
}