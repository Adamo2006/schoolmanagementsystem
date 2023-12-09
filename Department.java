import java.util.List;
import java.util.ArrayList;
public class Department
{
    private String id;
    private String name;
    private List<Course> courses;

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
        courses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void printCourses() {
        for (Course course : courses) {
            System.out.println(course.getcourseName());
        }
    }
    
    @Override
    public String toString() {
        return "Department{" +
               "id='" + id + '\'' +
               ", departmentName='" + name + '\'' +
               '}';
    }
    
}
