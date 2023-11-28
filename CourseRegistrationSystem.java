package CODSOFT;
import java.util.ArrayList;
import java.util.List;

// Courses class
class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    // Getters and setters for Courses class

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getRegisteredStudents() {
        return 0;
    }
}

// Student class
class Student {
    private int studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Getters and setters for Student class

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(Course course) {
        if (registeredCourses.size() < 5) { 
            //one student can choose upt to 5 courses only 
            registeredCourses.add(course);
            System.out.println(name + " registered for course: " + course.getCourseCode());
        } else {
            System.out.println("You have reached the maximum number of registered courses.");
        }
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        System.out.println(name + " dropped course: " + course.getCourseCode());
    }
}

// CourseListing class
class CourseListing {
    private List<Course> availableCourses;

    public CourseListing() {
        this.availableCourses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        availableCourses.add(course);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : availableCourses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + (course.getCapacity() - course.getRegisteredStudents()));
            System.out.println("-----------------------");
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Course course1 = new Course("Java", "Introduction to Java Programming", "Fundamentals of Java programming", 50,"Mon-Wed 09:30 AM");
        Course course2 = new Course("JS", "Introduction to JavaScript Programming", "Fundamentals of JavaScript programming", 45, "Tue-Thu 2:00 PM");
        Course course3 = new Course("Angular", "Introduction to Angular Framework", "Fundamentals of Angular Framework", 35, "Fri 10:00 AM");
        Course course4 = new Course("HTML & CSS", "Introduction to Web Technologies", "Fundamentals of Web technologies like HTML & CSS", 65, "Mon-Wed 2:00 PM");
        Course course5= new Course("SpringBoot", "Introduction to Spring Boot Framework", "Fundamentals of Sping Framework", 28, "Tue-Thu 09:30 AM");
        Course course6 = new Course("mySQL", "Introduction to Databases", "All about databses , mySQL", 32, "Fri 2:00 PM");

        CourseListing courseListing = new CourseListing();
        courseListing.addCourse(course1);
        courseListing.addCourse(course2);
        courseListing.addCourse(course3);
        courseListing.addCourse(course4);
        courseListing.addCourse(course5);
        courseListing.addCourse(course6);

        courseListing.displayCourses();

        Student student1 = new Student(1, "Shivaprasad");
        student1.registerForCourse(course1);
        student1.registerForCourse(course4);
        student1.registerForCourse(course3);
        student1.registerForCourse(course5);

        student1.dropCourse(course4);

        Student student2 = new Student(2, "Rohit");
        student2.registerForCourse(course2);
        student2.registerForCourse(course3);
        student2.registerForCourse(course4);
        student2.registerForCourse(course5);
        student2.registerForCourse(course6);

        student2.dropCourse(course6);

    }
}
