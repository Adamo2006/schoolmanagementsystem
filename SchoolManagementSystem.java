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
        System.out.println("\nDisplaying all departments:");
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
            return "\nCourse " + newCourse + " added successfully.";
        } else {
            return "Max courses reached, add a new course failed.";
        }
    }
    
     public String addTeacher(String teacherId, String firstName, String lastName, Department department) {
        if (teachers.size() < MAX_TEACHERS) {
            Teacher newTeacher = new Teacher(teacherId, firstName, lastName, department);
            teachers.add(newTeacher);
            return "\nTeacher " + newTeacher + " added successfully.";
        } else {
            return "Max teacher reached, add a new teacher failed.";
        }
    }

    
    public void displayTeachers() {
        System.out.println("\nDisplaying all teachers");
        System.out.println("-------------------");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
    
     private static final int MAX_STUDENTS = 5; // Example maximum number
    private List<Student> students = new ArrayList<>();

  public String addStudent(String id, String fname, String lname, String departmentId) {
        if (students.size() < MAX_STUDENTS) {
            Department department = findDepartmentById(departmentId);
            if (department == null) {
                return "Department not found, add a new student failed.";
            }
            Student newStudent = new Student(id, fname, lname, department);
            students.add(newStudent);
            return "\nStudent{id='" + id + "', fname='" + fname + "', lname='" + lname + "', department=Department(id=" + departmentId + ", departmentName='" + department.getName() + "'), courseNum=" + newStudent.getCourses().size() + ", courses=" + newStudent.getCourses() + "} added successfully.";
        } else {
            return "Max student reached, add a new student failed.";
        }
    }

    private Department findDepartmentById(String departmentId) {
        for (Department department : departments) {
            if (department.getId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }
    // Method to display all students
    public void displayStudents() {
        System.out.println("\nDisplaying all students");
          System.out.println("-------------------");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    

// Method to find a teacher by their ID
    private Teacher findTeacherById(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    // Method to find a course by its ID
    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    
    
 public String modifyCourseTeacher(String courseId, String teacherId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            return "Cannot find any course match with courseId " + courseId + ", modify teacher for course " + courseId + " failed.";
        }

        Teacher teacher = findTeacherById(teacherId);
        if (teacher == null) {
            return "Cannot find any teacher match with teacherId " + teacherId + ", modify teacher for course " + courseId + " failed.";
        }

        course.setTeacher(teacher);
        return course.toString() + " teacher info updated successfully.";
    }

    private static final int MAX_COURSES_PER_STUDENT = 5; // Max courses a student can register for
    private static final int MAX_STUDENTS_PER_COURSE = 5; // Max students a course can take
    
// Method to find a student by their ID
    private Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public String registerStudentForCourse(String studentId, String courseId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            return "Cannot find any student match with studentId " + studentId + ", register course for student " + studentId + " failed.";
        }

        Course course = findCourseById(courseId);
        if (course == null) {
            return "Cannot find any course match with courseId " + courseId + ", register course for student " + studentId + " failed.";
        }

        if (student.getCourses().size() >= MAX_COURSES_PER_STUDENT) {
            return "Student " + studentId + " has already registered " + MAX_COURSES_PER_STUDENT + " courses, register course for student " + studentId + " failed.";
        }

        if (course.getStudents().size() >= MAX_STUDENTS_PER_COURSE) {
            return "Course " + courseId + " has been fully registered, register course " + courseId + " for student " + studentId + " failed.";
        }

        // Bonus: Check if student has already registered for the course
        if (student.getCourses().contains(course)) {
            return "Student " + studentId + " has already registered Course " + courseId + ", register course " + courseId + " for student " + studentId + " failed.";
        }

        student.getCourses().add(course);
        course.getStudents().add(student);
        return "Student register course successfully\n" +
               "Latest student info: " + student + "\n" +
               "Latest course info: " + course;
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
        Department Mathematics = new Department("D002", "Mathematics");

    
    // Adding teachers
    System.out.println(obj.addTeacher("T001", "John", "Doe", computerScience));
    System.out.println(obj.addTeacher("T002", "Adamo", "Mario", Mathematics));
    // Example of adding a teacher beyond the limit
    
         obj.displayTeachers(); 
    
    

      // Add five students
        System.out.println(obj.addStudent("S001", "Mike", "Conan", "D001"));
        System.out.println(obj.addStudent("S002", "John", "Snow", "D001"));
        System.out.println(obj.addStudent("S003", "Sarah", "Jones", "D002"));
        System.out.println(obj.addStudent("S004", "Emma", "Stone", "D002"));
        System.out.println(obj.addStudent("S005", "David", "Smith", "D001"));

        // Display students
        obj.displayStudents();
    
    
          // Adding a course
    System.out.println(obj.addCourse("C001", "Intro to programming", 3.0, computerScience));
    
    // Modify the teacher of a course
String result = obj.modifyCourseTeacher("C001", "T001");
System.out.println(result);
result=obj.modifyCourseTeacher("C007", "T001");
System.out.println(result);
result=obj.modifyCourseTeacher("C001", "T007");
System.out.println(result);


    result = obj.registerStudentForCourse("S001", "C001");
    System.out.println(result);

    // Scenario 2: Register a student for a course - studentId not found
    result = obj.registerStudentForCourse("S007", "C001");
    System.out.println(result);

    // Scenario 3: Register a student for a course - courseId not found
    result = obj.registerStudentForCourse("S001", "C007");
    System.out.println(result);

    // Scenario 4: Register a student for a course - student has registered max courses
    // Assume student S001 is already registered for the maximum number of courses
    result = obj.registerStudentForCourse("S001", "C002");
    System.out.println(result);

    // Scenario 5: Register a student for a course - course is fully registered
    // Assume course C002 is already at maximum capacity
    result = obj.registerStudentForCourse("S002", "C002");
    System.out.println(result);

    // Scenario 6: (Bonus) Student register course - student has registered that course
    // Assume student S001 has already registered for course C001
    result = obj.registerStudentForCourse("S001", "C001");
    System.out.println(result);
    
    
    }
}

