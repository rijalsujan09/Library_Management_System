package library_Management_System;

import java.util.Scanner;

public class Student_Service {
	
	
	
//	Option For Student
//----------------------------------------------------------------------------------------------------------------------------------
	public static void studentfunction() {
		System.out.println("1. Borrow Book");
		System.out.println("2. Return Book");
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
				System.out.println(" Login Successfull.You can proceed further.");

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
