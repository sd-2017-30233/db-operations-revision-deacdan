/**
 * Created by dandeac on 15/03/2017.
 */
public class Course {
    private int id;
    private String name;
    private String teacher;
    private int year;

    public Course(int idC,String nameC, String teacherC,int yearC){
        this.id = idC;
        this.name=nameC;
        this.teacher=teacherC;
        this.year=yearC;
    }

    public int getId(){
        return id;
    }
    public void setId(int s_id){
        this.id=s_id;
    }
    public String getName(){
        return name;
    }
    public void setName(String s_name){
        this.name=s_name;
    }
    public String getTeacher(){
        return teacher;
    }
    public void setTeacher(String s_teacher){
        this.teacher=s_teacher;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int s_year){
        this.year=s_year;
    }

    public String toString(){
        return("Course info: id: " + id + " ,name:" + name + " ,teacher: " + teacher + " ,year of study: " + year);
    }
}
