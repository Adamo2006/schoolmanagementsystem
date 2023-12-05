import java.util.List;
import java.util.ArrayList;
public class Student {
    private int id;
    private String fname;
    private String lname;
    private Department department;
    private List<Course> courses;

    public Student(int id, String firstname,String lastname, Department department) {
        this.id = id;
        this.fname = firstname;
        this.lname=lastname;
        this.department = department;
        courses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return fname;
    }
     public String getLastName() {
        return lname;
    }


    public void setFirstName(String name) {
        this.fname = name;
    }
     public void setLastName(String name) {
        this.lname = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return fname;
    }
}