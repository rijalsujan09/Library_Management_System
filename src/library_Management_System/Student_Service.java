package library_Management_System;

import java.util.Scanner;

public class Student_Service {
	
	
	
//	Option For Student
//----------------------------------------------------------------------------------------------------------------------------------
	public static Student studentfunction() {
		System.out.println("1.View books in library:");
		System.out.println("2. Borrow Book");
		System.out.println("3. Return Book");
		return null;
	}
//----------------------------------------------------------------------------------------------------------------------------------

//	Login Function for Student
//----------------------------------------------------------------------------------------------------------------------------------
	public static void login_s(Scanner scan) {

		System.out.println();

		while (true) {
			System.out.println("Enter username::");
			String username = scan.next();

			System.out.println("Enter password");
			String password = scan.next();

			if (username.equals("b") && (password.contentEquals("2"))) {
				System.out.println(" Login Successfull.You can proceed further.\n");

				// FUNCTION

				studentfunction();

				break;

			} else {
				System.out.println("\nWrong Inputs.Try again!!\n");
				continue;
			}
		}

	}
//----------------------------------------------------------------------------------------------------------------------------------


}
