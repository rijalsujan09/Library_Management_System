package library_Management_System;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);

	static int choice = 0;

	public static void main(String[] args)
			throws InterruptedException, ClassNotFoundException, IOException, SQLException {

		String[] Heading = { "\n" + "\t\t\t\t\t Welcome", " to", " Library", " Management", " System" };

		for (int i = 0; i < Heading.length; i++) {
			System.out.print(Heading[i]);
			Thread.sleep(100);
		}
		System.out.println();
		login_l(scan);

		// Users.usertype(scan);
		System.out.println("Choose from the following options:");
		// Librarian.librarianfunction(scan);
		LibrarianService lb = new LibrarianService();

		while (true) {
			System.out.println("1.librarianfunction");

			System.out.println("\nEnter your choice::");
			choice = scan.nextInt();
			if (choice == 1) {
				librarianfunction(scan);
			}
			break;
		}

	}

	public static void librarianfunction(Scanner scan) throws ClassNotFoundException, IOException, SQLException {

		System.out.println("1. Add Students");
		System.out.println("2. Add Books to library ");
		System.out.println("3. View All Students");
		System.out.println("4.View All Books ");
		System.out.println("5. Issue books for Students");
		System.out.println("6. Entry of return books");
		System.out.println("7. Remove books from library");
		System.out.println("8. Exit from system");

		System.out.println("\nEnter your choice::");

		choice = scan.nextInt();

		{
			if (choice == 1) {
				// Add Students
				// ---------------------------------------------------------------------------------------------------------
				System.out.println("Enter studentid");
				int studentid = scan.nextInt();
				System.out.println("Enter first name::");
				String firstname = scan.next();

				System.out.println("Enter last name::");
				String lastname = scan.next();

				System.out.println("Enter your emailid:");
				String email = scan.next();
				Student Student1 = new Student(studentid, firstname, lastname, email);
				BooksDaoInterface db = new BooksDaoDb();
				db.addstudent(Student1);

			} else if (choice == 2) {
				// Add books to library
				// ----------------------------------------------------------------------------------------------------------
				System.out.println("Enter serial number of book:");
				int serialNo = scan.nextInt();
				System.out.println("Enter book name: ");
				String bookName = scan.next();
				System.out.println("Enter Author Name:");
				String authorName = scan.next();
				System.out.println("Enter quantity of book: ");
				int bookquantity = scan.nextInt();

				Books book1 = new Books(serialNo, bookName, authorName, bookquantity);
				BooksDaoInterface db = new BooksDaoDb();
				db.addbook(book1);

			} else if (choice == 3) {

				// View all Students
				// call method for viewing students/
				System.out.println("\t\tAll Students :\n");
				BooksDaoInterface db = new BooksDaoDb();
				db.viewAllStudent();

				// -----------------------------------------------------------------------------------------------------------
			} else if (choice == 4) {
				// View all books
				System.out.println("\t\tAll books in Library:\n");
				BooksDaoInterface db = new BooksDaoDb();
				db.viewbooks();

			} else if (choice == 5) {
				// issue books for student
				// ----------------------------------------------------------------------------------------------------------
				// if Student is registered
				System.out.println("Enter Student id:");
				int studentid = scan.nextInt();
				int bookscount = 0;
				//Student st = new Student();
				LibrarianService ls = new LibrarianService();
				
//need to fix issue comparing 
				if ( studentid==ls.searchbystudentid() ) {

					System.out.println("Enter issuedate : ");
					LocalDate issueddate = null;
					String issueddate1 = scan.next();
					issueddate = LocalDate.parse(issueddate1, DateTimeFormatter.ISO_LOCAL_DATE);

					System.out.println("Enter returneddate: ");
					String returneddate1 = scan.next();
					LocalDate returneddate = LocalDate.parse(issueddate1, DateTimeFormatter.ISO_LOCAL_DATE);
					System.out.println("Number of books to be  issued:");
					int qbooks = scan.nextInt();
					if (qbooks > 3) {
						System.out.println("Student cannot borrow more than 3 books");
					} else {

						for (int i = 0; i < qbooks; i++) {
							System.out.println("Enter SerialNo of book to issue  ");
							int serialNo = scan.nextInt();
							Books bk = new Books();
							if (bk.getSerialNo() == serialNo) {

								bookscount++;

							} else {
								System.out.println("Book doesnot exist in system.");

							}

						}

						System.out.println("books issued " + bookscount);

					}
				} else {
					System.out.println("You are not registered in Student list yet."
							+ " And  you cannot issue any books until you don't get registered");
				}
				Books book1 = new Books();
				BooksDaoInterface db = new BooksDaoDb();
				db.issuedbooks(book1);

			} else if (choice == 6) {
				// Entry of return books
				// ---------------------------------------------------------------------------------------------------------
				System.out.println("Enter Student id:");
				int studentid = scan.nextInt();

				// if Student is registered

				if (studentid == studentid) {
					System.out.println("Enter SerialNo of book to return  ");
					String bname = scan.next();
					System.out.println("Enter return date:");
					LocalDate date = LocalDate.now();
					System.out.println("Number of books :");
					int books = scan.nextInt();

					System.out.println("books returned");

				} else {
					System.out.println("You are not registered in Student list ");

				}
				Books book1 = new Books();
				BooksDaoInterface db = new BooksDaoDb();
				db.returnedbooks(book1);

			} else if (choice == 6) {

				// -----------------------------------------------------------------------------------------------------------
				// Remove books from library
				System.out.println("Enter serial number of book:");
				int sNo = scan.nextInt();

				System.out.println("Enter quantity of book: ");
				int quantity = scan.nextInt();
				Books book1 = new Books();
				BooksDaoInterface db = new BooksDaoDb();
				db.removebooks(book1);
			}
		}

	}
	// ---------------------------------------------------------------------------------------------------------------------------

//		login function of librarian
	// ----------------------------------------------------------------------------------------------------------------------------------
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
				// librarianfunction(scan);

				break;

			} else {
				System.out.println("\nWrong Inputs.Try again!!\n");

				continue;
			}
		}

	}

}
