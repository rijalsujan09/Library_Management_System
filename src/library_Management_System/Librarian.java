package library_Management_System;

import java.util.Scanner;

public class Librarian {

//	OPTIONS for librarian
//---------------------------------------------------------------------------------------------------------------------------
	public static void librarianfunction(Scanner scan) {

		System.out.println("1. Add Students");
		System.out.println("2. Add Books to library ");
		System.out.println("3. View All users");
		System.out.println("4. Issue books for Students");
		System.out.println("5. Entry of return books");
		System.out.println("6. Remove books from library");
		System.out.println("7. Exit from system");

		System.out.println("\nEnter your choice::");

		int choice = scan.nextInt();

		{
			if (choice == 1) {
				// Add Students

				System.out.println("Enter first name::");
				String firstName = scan.next();

				System.out.println("Enter last name::");
				String lastName = scan.next();

				System.out.println("Enter your emailid:");
				String email = scan.next();
			
			} else if (choice == 2) {
				// Add books to library
				System.out.println("Enter serial number of book:");
				int sNo = scan.nextInt();
				System.out.println("Enter book name: ");
				String bookname = scan.next();
				System.out.println("Enter Author Name:");
				String Author = scan.next();
				System.out.println("Enter quantity of book: ");
				int quantity = scan.nextInt();

			} else if (choice == 3) {
				// View all users/Students
			}
		}

	}
//---------------------------------------------------------------------------------------------------------------------------

//	login function of librarian
//----------------------------------------------------------------------------------------------------------------------------------
	public static void login_l(Scanner scan) {

		System.out.println();

		while (true) {
			System.out.println("Enter username:: ");
			String username = scan.next();

			System.out.println("Enter password:: ");
			String password = scan.next();

			if (username.equals("a") && (password.contentEquals("1"))) {
				System.out.println("Login Successfull.You can proceed further.");

				// FUNC
				librarianfunction(scan);

				break;

			} else {
				System.out.println("\nWrong Inputs.Try again!!\n");

				continue;
			}
		}
	}
//---------------------------------------------------------------------------------------------------------------------------------	

}
