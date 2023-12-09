import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Teacher teacher;
    private Department department;
    private List<Student> students;
    

    public String getcourseName() {
        return courseName;
    }
    
    public Course(String courseId, String courseName, double credits, Department department) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.students = new ArrayList<>();
        this.teacher = null;  // Initially, no teacher is assigned
    }
    
public String getId() {
        return courseId;
    }
    // Method to set the teacher of the course
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
     public List<Student> getStudents() {
        return students;
    }

    public String toString() {
        StringBuilder studentNames = new StringBuilder();
        for (Student student : students) {
            studentNames.append(student.getFirstName()).append(" ").append(student.getLastName()).append(", ");
        }
        return "Course{id='" + courseId + "', courseName='" + courseName + "', credit=" + credits +
               ", teacher=" + (teacher != null ? teacher.getFirstName() + " " + teacher.getLastName() : "null") +
               ", department='" + department.getName() + "', students=[" + studentNames + "]}";
    }

    // Getters and setters for all fields
}
