import java.util.ArrayList;
import java.util.List;

public class SchoolManagementSystem {

    private static final int MAX_DEPARTMENTS = 5;
    private List<Department> departments = new ArrayList<>();

    // Method to add a department
    public String addDepartment(String id, String name) {
        if (departments.size() < MAX_DEPARTMENTS) {
            Department newDepartment = new Department(id, name);
            departments.add(newDepartment);
            return "Add department " + name + " successfully.";
        } else {
            return "Max department reached, add a new department failed.";
        }
    }

    // Method to display all departments
    public void displayDepartments() {
        System.out.println("Displaying all departments:");
        System.out.println("-------------------");
        for (Department dept : departments) {
            System.out.println(dept);
        }
    }

    private static final int MAX_TEACHERS = 20;
    private static final int MAX_COURSES = 30;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    // Other fields and methods...

    // Method to add a course
    public String addCourse(String courseId, String courseName, double credits, Department department) {
        if (courses.size() < MAX_COURSES) {
            Course newCourse = new Course(courseId, courseName, credits, department);
            courses.add(newCourse);
            return "Course " + newCourse + " added successfully.";
        } else {
            return "Max courses reached, add a new course failed.";
        }
    }
    
     public String addTeacher(String teacherId, String firstName, String lastName, Department department) {
        if (teachers.size() < MAX_TEACHERS) {
            Teacher newTeacher = new Teacher(teacherId, firstName, lastName, department);
            teachers.add(newTeacher);
            return "Teacher " + newTeacher + " added successfully.";
        } else {
            return "Max teacher reached, add a new teacher failed.";
        }
    }
    
    public static void main(String[] args) {
        SchoolManagementSystem obj = new SchoolManagementSystem();

        // Adding five different departments
        System.out.println(obj.addDepartment("D001", "Computer Science"));
        System.out.println(obj.addDepartment("D002", "Mathematics"));
        System.out.println(obj.addDepartment("D003", "Physics"));
        System.out.println(obj.addDepartment("D004", "Chemistry"));
        System.out.println(obj.addDepartment("D005", "Biology"));
        System.out.println(obj.addDepartment("D006", "English"));

        // Display departments
        obj.displayDepartments();
        Department computerScience = new Department("D001", "Computer Science");

        // Adding a course
    System.out.println(obj.addCourse("C001", "Intro to programming", 3.0, computerScience));

    // Adding teachers
    System.out.println(obj.addTeacher("T001", "John", "Doe", computerScience));
    // Example of adding a teacher beyond the limit
    }
}

