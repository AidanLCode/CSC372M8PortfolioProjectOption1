import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean moreData = true;

        while (moreData) {
            //Prompt the user for student data
            System.out.println("Enter student's name: ");
            String name = scanner.nextLine();

            System.out.println("Enter student's address: ");
            String address = scanner.nextLine();

            double GPA = -1; //Initialize the GPA to an invalid value.
            while (GPA < 0 || GPA > 4) { //Keep prompting for valid GPA.
                System.out.println("Enter student's GPA (0.0 to 4.0): ");
                while (!scanner.hasNextDouble()) { //Verify that it is an actual double
                    System.out.println("Invalid input. Please enter a number for GPA: ");
                    scanner.next();
                }
                GPA = scanner.nextDouble();
                scanner.nextLine();
                if (GPA < 0 || GPA > 4) {
                    System.out.println("Invalid GPA. Please enter a double between (0.0 to 4.0)");
                }

            }

            //Create a new student object and add it to the list
            Student student = new Student(name,address,GPA);
            students.add(student);

            //Ask user if they want to add more students
            System.out.println("Do you want to add another student (yes/no)");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!answer.equals("yes")){
                moreData = false;
            }
        }

        //Sort the list of students by name
        Collections.sort(students, (s1,s2) -> s1.getName().compareTo(s2.getName()));

        //Write the sorted list of students names to a file using a exception handling
        try (FileWriter writer = new FileWriter("/Users/cubbyevil/Documents/Aidan College/CSU/Courses/Winter 2023/Term C/Prog II CSC372 /Module 8 /Portfolio Project/student.txt")){
            for (Student student : students){
                writer.write(student.toString() + "\n" );
            }
            System.out.println("Student data has been written to student.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
