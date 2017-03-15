import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by dandeac on 15/03/2017.
 */



public class DatabaseManagement {

    public static void main(String[] args) throws Exception{
        Connection conn = getConnection();


        while(true){
            Scanner input = new Scanner(System.in);

            System.out.println("Type your choice:");
            System.out.println("1 - Add student");
            System.out.println("2 - Remove student");
            System.out.println("3 - Update student");
            System.out.println("4 - Add course");
            System.out.println("5 - Remove course");
            System.out.println("6 - Update course");
            System.out.println("7 - Enroll");
            System.out.println("8 - Exit");

            int option = input.nextInt();

            switch (option){

                case 1: Scanner in = new Scanner(System.in);
                    System.out.println("Type the id: ");
                    int id = in.nextInt();
                    System.out.println("Type the name: ");
                    String name = in.next();
                    System.out.println("Type the birth year: ");
                    int birth = in.nextInt();
                    System.out.println("Type the address: ");
                    String address = in.next();
                    Student student = new Student(id,name,birth,address);

                    addStudent(conn,student);
                    break;
                case 2:
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("Type the id of the student you want to delete: ");
                    int idS = in2.nextInt();
                    Student student1 = new Student(idS,"",0,"");

                    removeStudent(conn,student1);
                    break;
                case 3:
                    Scanner in3 = new Scanner(System.in);
                    System.out.println("Type the id of the student you want to update: ");
                    int id3 = in3.nextInt();
                    System.out.println("Type the new name: ");
                    String newName = in3.next();
                    System.out.println("Type the new birth year: ");
                    int newBirth = in3.nextInt();
                    System.out.println("Type the new address: ");
                    String newAddress = in3.next();
                    Student student3 = new Student(id3,newName,newBirth,newAddress);

                    updateStudent(conn,student3);
                    break;
                case 4: Scanner in4 = new Scanner(System.in);
                    System.out.println("Type the id: ");
                    int id4 = in4.nextInt();
                    System.out.println("Type the name: ");
                    String nameC = in4.next();
                    System.out.println("Type the teacher name: ");
                    String teacher = in4.next();
                    System.out.println("Type the year: ");
                    int year= in4.nextInt();
                    Course course = new Course(id4,nameC,teacher,year);

                    addCourse(conn, course);
                    break;
                case 5: Scanner in5 = new Scanner(System.in);
                    System.out.println("Type the id of the course you want to delete: ");
                    int id5 = in5.nextInt();
                    Course course1 = new Course(id5,"","",0);

                    removeCourse(conn,course1);
                    break;
                case 6: Scanner in6 = new Scanner(System.in);
                    System.out.println("Type the id of the course you want to update: ");
                    int id6 = in6.nextInt();
                    System.out.println("Type the new name: ");
                    String newName6 = in6.next();
                    System.out.println("Type the new teacher name: ");
                    String newTeacher = in6.next();
                    System.out.println("Type the new year of study: ");
                    int newYear = in6.nextInt();
                    Course course2 = new Course(id6,newName6,newTeacher,newYear);

                    updateCourse(conn,course2);
                    break;
                case 7: enroll(conn);
                        break;
                case 8: System.exit(0);
                    break;


            }
        }
    }


    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/SchoolDatabase";
            Class.forName(driver);
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,username,password);

            return conn;

        } catch(Exception e){
            System.out.println(e);
        }


        return null;
    }

    public static boolean addStudent(Connection conn, Student stud) throws Exception{

        int id = stud.getId();
        String name = stud.getName();
        int birth = stud.getBirth();
        String address = stud.getAddress();


        try{

            PreparedStatement posted = conn.prepareStatement("INSERT INTO `students` (`id`, `name`, `birth`, `address`) VALUES ('"+ id +"', '"+name+"', '"+birth+"', '"+address+"')");

            posted.executeUpdate();
            return true;
        }  catch(Exception e){
            System.out.println(e);
        }

        return false;

    }

    public static boolean removeStudent(Connection conn,Student student) throws Exception{
        int id = student.getId();

        try{

            PreparedStatement posted = conn.prepareStatement("DELETE FROM `students` WHERE `id` = '"+id+"'");
            posted.executeUpdate();
            return true;
        }  catch(Exception e){
            System.out.println("The ID that you type in, doesn't appear in the db");
        }
        return false;
    }

    public static boolean updateStudent(Connection conn, Student student) throws Exception {

        int id = student.getId();
        String newName = student.getName();
        int newBirth = student.getBirth();
        String newAddress = student.getAddress();


        try {

            PreparedStatement posted = conn.prepareStatement("UPDATE `students` SET `id`= '" + id + "',`name`= '" + newName + "',`birth`='" + newBirth + "',`address`='" + newAddress + "' WHERE `id` = '" + id + "'");
            posted.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("The ID that you type in, doesn't appear in the db");
        }
        return false;
    }

    public static boolean addCourse(Connection conn,Course course) throws Exception{
        int id = course.getId();
        String name =  course.getName();
        String teacher = course.getTeacher();
        int year = course.getYear();



        try{

            PreparedStatement posted = conn.prepareStatement("INSERT INTO `courses` (`id`, `name`, `teacher`, `year`) VALUES ('"+ id +"', '"+name+"', '"+teacher+"', '"+year+"')");

            posted.executeUpdate();
            return true;
        }  catch(Exception e){
            System.out.println(e);
        }

        return false;
    }

    public static boolean removeCourse(Connection conn,Course course) throws Exception{
        int id = course.getId();

        try{

            PreparedStatement posted = conn.prepareStatement("DELETE FROM `courses` WHERE `id` = '"+id+"'");
            posted.executeUpdate();
            return true;
        }  catch(Exception e){
            System.out.println("The ID that you type in, doesn't appear in the db");
        }
        return false;
    }

    public static boolean updateCourse(Connection conn, Course course) throws Exception{

        int id = course.getId();
        String newName = course.getName();
        String newTeacher = course.getTeacher();
        int newYear = course.getYear();

        try{

            PreparedStatement posted = conn.prepareStatement("UPDATE `courses` SET `id`= '"+id+"',`name`= '"+newName+"',`teacher`='"+newTeacher+"',`year`='"+newYear+"' WHERE `id` = '"+id+"'");
            posted.executeUpdate();
            return true;
        }  catch(Exception e){
            System.out.println("The ID that you type in, doesn't appear in the db");
        }
        return false;
    }

    public static boolean enroll(Connection conn) throws Exception{
        Scanner in = new Scanner(System.in);

        System.out.println("Type the id of the student you want to enroll: ");
        int idS = in.nextInt();
        System.out.println("Type the id of the course you want to enroll the student: ");
        int idC = in.nextInt();
        System.out.println("Type the id of the enroll: ");
        int id = in.nextInt();

        try{

            PreparedStatement posted = conn.prepareStatement("UPDATE `enroll` SET `id`= '"+id+"',`idS`= '"+idS+"',`idC`='"+idC+"'");
            posted.executeUpdate();
            return true;
        }  catch(Exception e){
            System.out.println(e);
        }

        return false;
    }
}
