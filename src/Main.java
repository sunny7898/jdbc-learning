import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDAO;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student Management App!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Press 1 to ADD student");
            System.out.println("Press 2 to DELETE student");
            System.out.println("Press 3 to DISPLAY student");
            System.out.println("Press 4 to EXIT");

            int choice = Integer.parseInt(br.readLine());
            if (choice == 1) {
            	System.out.println("Enter user name, phone, and city: ");
            	String name = br.readLine();
            	String phone = br.readLine();
            	String city = br.readLine();
            	
            	Student student = new Student(name, phone,city);
            	System.out.println(student);
            	
            	boolean status = StudentDAO.insertStudentToDB(student);
            	System.out.println(status ? 
            			"User added successfully!" : 
            				"User couldn't be added!");
            	
            	
            	
            } else if (choice == 2) {
            	System.out.println("Enter user id");
            	int userId = Integer.parseInt(br.readLine());
            	boolean status = StudentDAO.deleteStudentUsingId(userId);
            	System.out.println(status ? 
            			"User deleted successfully!" : 
            				"Something went wrong!");
            	
            	
            } else if (choice == 3) {
            	StudentDAO.showAllStudents();
            } else if (choice == 4) {
            	System.out.println("Bye bye!!");
                break;
            } else {
                System.out.println("Incorrect choice entered");
            }
        }

    }
}