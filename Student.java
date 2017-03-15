import java.util.Date;

/**
 * Created by dandeac on 15/03/2017.
 */
public class Student {

    private int id;
    private String name;
    private int birth;
    private String address;

    public Student(int idS,String nameS,int birthS, String addressS){
        this.id = idS;
        this.name = nameS;
        this.birth = birthS;
        this.address = addressS;
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

    public int getBirth(){
        return birth;
    }

    public void setBirth(int birthDate){
        this.birth=birthDate;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String s_adress){
        this.address=s_adress;
    }


    public String toString(){
        return("Info student: name: " + name + " ,id: " + id + " ,birth date: " + birth + " ,adress: " + address);
    }
}
