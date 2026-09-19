import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add Student
    static void addStudent() {

        Student student = new Student();

        System.out.print("Enter Student ID: ");
        student.id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        student.name = sc.nextLine();

        System.out.print("Enter Student Marks: ");
        student.marks = sc.nextDouble();

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // View Students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n===== Student List =====");

        for (Student student : students) {
            System.out.println(
                "ID: " + student.id +
                " | Name: " + student.name +
                " | Marks: " + student.marks
            );
        }
    }

    // Search Student
    static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int searchId = sc.nextInt();

        for (Student student : students) {

            if (student.id == searchId) {

                System.out.println("\nStudent found!");
                System.out.println("ID: " + student.id);
                System.out.println("Name: " + student.name);
                System.out.println("Marks: " + student.marks);

                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Update Student
    static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int updateId = sc.nextInt();

        for (Student student : students) {

            if (student.id == updateId) {

                sc.nextLine();

                System.out.print("Enter new name: ");
                student.name = sc.nextLine();

                System.out.print("Enter new marks: ");
                student.marks = sc.nextDouble();

                System.out.println("Student updated successfully!");

                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Delete Student
    static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int deleteId = sc.nextInt();

        for (Student student : students) {

            if (student.id == deleteId) {

                students.remove(student);

                System.out.println("Student deleted successfully!");

                return;
            }
        }

        System.out.println("Student not found!");
    }
}