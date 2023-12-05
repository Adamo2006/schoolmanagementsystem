import java.util.List;
import java.util.ArrayList;

public class Teacher {
    private String teacherId;
    private String firstName;
    private String lastName;
    private Department department;
    private List<Course> courses;

    public Teacher(String teacherId, String firstName, String lastName, Department department) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.courses = new ArrayList<>();
    }

    // Getters and setters
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "Teacher{id='" + teacherId + "', fname='" + firstName + "', lname='" + lastName +
               "', department='" + department.getName() + "'}";
    }
}
