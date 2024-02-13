import java.util.ArrayList;
import java.util.Scanner;

// Creating the Person class as Abstract as a Base Class
abstract class Person
{
    public int id;
    public String name;
    public int age;

    // Constructor of the Person class
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    abstract void getDetails();
}

// Creating the Student class which extend the Person class
class student extends Person
{
    int studentId;
    // List to store the courses of each student that they enroll
    ArrayList<course> courses ;

    // Constructor of the student class
    public student(int studentId, String name, int age) {
        super(studentId, name, age);
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(course ch)
    {
        courses.add(ch);
    }

    // Method to display the student details
    public void getDetails()
    {
        System.out.print("Student id of Student is "+studentId + " with courses ");
        for(int i=0;i<courses.size();i++)
        {
            System.out.print(courses.get(i).getCourseName());
        }
        System.out.println();
    }
}

class faculty extends Person
{
    int employeeId;
    String department;
    // List to store the courses of the faculty that they teach
    ArrayList<course> facultycourses;

    // Constructor of the faculty class
    public faculty(int employeeId, String name, int age, String department) {
        super(employeeId, name, age);
        this.employeeId = employeeId;
        this.department = department;
        facultycourses = new ArrayList<>();
    }

    // Methos to add courses that teacher teaches
    public void teachCourse(course c)
    {
        facultycourses.add(c);
    }

    // Methos to print the details of the the teacher
    public void getDetails()
    {
        System.out.print("Employee id of Employee is "+employeeId +" and department is "+ department);
        System.out.println();
    }

}

class course
{
    private String courseCode;
    private String courseName;
    private int credits;
    
    // Constructor of the Course class 
    public course(String courseCode, String courseName,int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }


    // getter of the course class that access the private data members
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits()
    {
        return credits;
    }
    
}

class university
{
    // List to store student that are enrolled in the University
    ArrayList<student> studentList = new ArrayList<>();

    // List to store faculty that are enrolled in the University
    ArrayList<faculty> facultyList = new ArrayList<>();

    // List to store courses that are enrolled in the University
    ArrayList<course> courseList = new ArrayList<>();


    // method to add student in the university
    public void addStudent(student s)
    {
        studentList.add(s);
    }

    // method to remove student in the university when Student Id mathches
    public void removeStudent(int stId)
    {
        for(int i=0;i<studentList.size();i++)
        {
            if(studentList.get(i).studentId == stId)
            {
                studentList.remove(i);
                break;
            }
        }
    }

    // method to add faculty in the university
    public void addFaculty(faculty f)
    {
        facultyList.add(f);
    }

    // method to remove faculty when Faculty id matches
    public void removeFaculty(int factId)
    {
        for(faculty i:facultyList)
        {
            if(i.employeeId == factId)
            {
                facultyList.remove(i);
                break;
            }
        }
    }


    // Add courses in the university
    public void addCourse(course c)
    {
        courseList.add(c);
    }

    // method to remove the course when name of the courses mathes which is present in the list
    public void removeCourse(String name)
    {
        for(course i:courseList)
        {
            if(i.getCourseName().equals(name))
            {
                courseList.remove(i);
                break;
            }
        }
    }

    // Display all the details of the Student, Faculty and course
    public void displayAllDetails()
    {
        System.out.println("Details of student is ");
        for(student s:studentList)
        {
            s.getDetails();
        }

        System.out.println("Details  of teacher is");
        {
            for(faculty f:facultyList)
            {
                f.getDetails();
            }
        }

        System.out.println("Details of course is");
        {
            for(course i:courseList)
            {
                System.out.print(i.getCourseCode() + " " + i.getCourseName() + " " +  i.getCredits());
            }
            System.out.println();
        }
    }
}


public class UniversityManagement {
    public static void main(String[] args) {

        boolean flag= true;
        Scanner sc = new Scanner(System.in);
        university u = new university();
        do{
            System.out.println("****UNIVERSITY MAGEMENT SYSTEM*******");
            System.out.println("1.Add student\n2.Remove Student\n3.Add faculty\n4.Remove Faculty\n5.Add Course\n6.Remove Course\n7.Display University Details\n8.Exit");
            System.out.print("Enter the choice: ");
            int ch= sc.nextInt();

            switch (ch) {
                case 1:
                // Enterning detail of the student for enrolling in the university
                    System.out.print("Enter the student ID: ");
                    int id= sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the student name: ");
                    String name= sc.nextLine();
                    System.out.print("Enter the student age: ");
                    int age= sc.nextInt();
                    student s = new student(id, name, age);

                    System.out.print("Enter the number of courses student want to enroll ");
                    int si = sc.nextInt();
                    sc.nextLine();

                    boolean r = false;
                    course temp = new course("", "", -1);
                    for(int i=0;i<si;i++)
                    {
                        System.out.print("Enter the Course code: ");
                        String code = sc.nextLine();
                        System.out.println(u.courseList.size());
                        for(int k=0;k<u.courseList.size();k++)
                        {
                            if(u.courseList.get(k).getCourseCode().equals(code))
                            {
                                temp = u.courseList.get(k);
                                r = true;
                            }
                        }
                        if(r == false)
                        {
                            System.out.println("No course available ");
                            break;
                        }
                        
                    }
                    if(r != false)
                    {
                        s.enrollCourse(temp);
                        u.addStudent(s);
                    }

                    break;
                case 2:
                // Removing the student from the university
                    System.out.print("Enter the student ID: ");
                    int stuid= sc.nextInt();
                    u.removeStudent(stuid);
                    break;
                case 3:
                // Enterning the Employee in the university
                    System.out.print("Enter the employee ID: ");
                    int i= sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the employee name: ");
                    String n= sc.nextLine();
                    System.out.print("Enter the employee age: ");
                    int a= sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the department: ");
                    String d = sc.nextLine();
                    faculty f = new faculty(i, n, a, d);
                    u.addFaculty(f);
                    break;
                case 4:
                // Removing the teacher from the university
                    System.out.print("Enter the employee ID: ");
                    int empid= sc.nextInt();
                    u.removeFaculty(empid);
                    break;
                case 5:
                // Registerning the course in the university
                    System.out.print("Enter the Course code: ");
                    String code = sc.next();
                    System.out.print("Enter the course name");
                    String cName= sc.next();
                    System.out.print("Enter the course credit: ");
                    int credit= sc.nextInt();
                    course c = new course(code, cName, credit);
                    u.addCourse(c);
                    break;
                case 6:
                // removing the course when mathces
                    System.out.print("Enter the course name: ");
                    String nn = sc.nextLine();
                    u.removeCourse(nn);
                    break;
                case 7:
                // To display all the deatils of student, Faculty and courses that are present in the university
                    u.displayAllDetails();
                    break;
                case 8:
                    flag=false;
                    System.out.println("Thank You ^_^");

                    break;
            
                default:
                    break;
            }
        }while(flag);
        sc.close();
    }
}
