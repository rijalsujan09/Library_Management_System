package library_Management_System;

import java.util.Scanner;

public class Users {

	public static void usertype(Scanner scan) {

		UserType type = null;
		while (true) {
			System.out.println("\n\n\t\t\t\t\t   1.librarian\t  \t 2.Student");
			System.out.println("\t\t\t--------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t         Choose the user type:");
			System.out.println("ENTER: ");
			int userChoice = scan.nextInt();
			if (userChoice == 1) {
				type = UserType.lIBRARIAN;

				// login
				Librarian.login_l(scan);

				break;

			} else if (userChoice == 2) {
				type = UserType.STUDENT;
				// LOGIN
				Student_Service.login_s(scan);
				break;
			} else {
				System.out.println("Invalid option.");
				continue;
			}
		}
	}

}
