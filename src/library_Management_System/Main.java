package library_Management_System;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	static LocalDate expectedreturndate = null;

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
		System.out.println("Librarian functions:\n");
		// Librarian.librarianfunction(scan);
		LibrarianService lb = new LibrarianService();

		while (true) {
			//

			System.out.println("1. Add Students");
			System.out.println("2. Add Books to library ");
			System.out.println("3. View All Students");
			System.out.println("4. View All Books ");
			System.out.println("5. Issue books for Students");
			System.out.println("6. Entry of return books");
			System.out.println("7. Remove books from library");
			System.out.println("8. Exit from system");

			System.out.println("\nEnter your choice::");

			int choice = scan.nextInt();

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
//---------------------------------------------------------------------------------------------------------
// View all Students
// call method for viewing students
				System.out.println("\t\tAll Students :\n");
				BooksDaoInterface db = new BooksDaoDb();
				db.viewAllStudent();

			} else if (choice == 4) {
// -----------------------------------------------------------------------------------------------------------
// View all books		

				System.out.println("\t\tAll books in Library:\n");
				BooksDaoInterface db = new BooksDaoDb();
				db.viewbooks();

			} else if (choice == 5) {
// issue books for student
// ----------------------------------------------------------------------------------------------------------
// conditions required ::				
// if Student is registered or not
// limit for borrowing books				
//if book exist in library or not 
//All done				
				System.out.println("Enter Student id:");
				int studentid = scan.nextInt();
				int bookscount = 0;

				LibrarianService ls = new LibrarianService();
				boolean b = ls.searchbystudentid(studentid);

				if (ls.searchbystudentid(studentid)) {

					System.out.println("Enter issuedate : ");
					LocalDate issueddate = null;
					int serialNo = 0;
					LocalDate returneddate = null;
					String issueddate1 = scan.next();
					issueddate = LocalDate.parse(issueddate1, DateTimeFormatter.ISO_LOCAL_DATE);
//books must be returned by 14 days from issueddate

					expectedreturndate = issueddate.plusDays(14);

					System.out.println("\nNumber of books to be  issued:");
					int bookquantity = scan.nextInt();
					if (bookquantity > 3) {
						System.out.println("Student cannot borrow more than 3 books");
					} else {

						for (int i = 0; i < bookquantity; i++) {
							System.out.println("Enter SerialNo of book to issue  ");
							serialNo = scan.nextInt();
							if (ls.searchbyserialNo(serialNo)) {

								bookscount++;

							} else {
								System.out.println("Book doesnot exist in system.");

							}

							System.out.println(" You issued  " + bookscount + " books \nExpected returndate:"
									+ expectedreturndate);

						}

						Books books = new Books(studentid, issueddate, bookquantity, serialNo, expectedreturndate);

						BooksDaoInterface db = new BooksDaoDb();
						db.issuedbooks(books);
					}
				} else {
					System.out.println("You are not registered in Student list yet."
							+ " And  you cannot issue any books until you don't get registered");
				}

			} else if (choice == 6) {
// Entry of return books
// ---------------------------------------------------------------------------------------------------------
//match studentid to make book return entry 
// we can add more functions here give time limit for returning books and if delayed ,charge delayed fee.
// not done				
				System.out.println("Enter Student id:");
				int studentid = scan.nextInt();
				int bookscount = 0;
				int serialNo = 0;
				LibrarianService ls = new LibrarianService();
				boolean b = ls.searchbystudentid(studentid);

				if (ls.searchbystudentid(studentid)) {
					System.out.println("Enter quantity of returning books:");
					int bookquantity = scan.nextInt();

					System.out.println("Enter SerialNo of book to return  ");
					serialNo = scan.nextInt();
					for (int i = 0; i < bookquantity; i++) {
						if (ls.searchbyserialNo(serialNo)) {

							bookscount++;

						} else {
							System.out.println("Book doesnot exist in system.");

						}

					}

					System.out.println(" You Returned  " + bookscount + "of SerialNo: " + serialNo);

					System.out.println(" Enter Returned date: ");
					LocalDate returneddate = null;
					String returneddate1 = scan.next();
					returneddate = LocalDate.parse(returneddate1, DateTimeFormatter.ISO_LOCAL_DATE);

					// returneddate =LocalDate.now();
					// In actual system above commented method can be used to avoid user(librarian)
					// manipulation/error.
					// and it can be applied to issuedate also.

					System.out.println(returneddate);
					Period period = Period.between(expectedreturndate, returneddate);
					System.out.print(period.getDays() + " Latedays ");

					// Period period = Period.between(expectedreturndate, returneddate);

					System.out.println("Number of books to be returned :");
					int books = scan.nextInt();

					System.out.println("books returned " + books);

				} else {
					System.out.println("Student not found ");

				}

			} else if (choice == 7) {

// -----------------------------------------------------------------------------------------------------------
//Librarian functionality				
// Remove books from library
				while (true) {
					System.out.println("Enter serial number of book:");
					int serialNo = scan.nextInt();
					LibrarianService ls = new LibrarianService();

					if (ls.searchbyserialNo(serialNo)) {

						System.out.println("Book found ");

						// bookscount++;

					} else {
						System.out.println("Book doesnot exist in system.\n");
						continue;
					}
					break;
				}

				System.out.println("Enter quantity of book: ");
				int quantity = scan.nextInt();
//After removing book from booklist  , quantity of book should decrease in sql table.
// for this we have to write a proper query 				
				
				
				Books book1 = new Books();
				BooksDaoInterface db = new BooksDaoDb();
				db.removebooks(book1);
				System.out.println("Books Removed : ");
				System.out.println("Books removed "+ book1 + " and remaining book of this serialno in booklist is: ");
			}
			continue;
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
				System.out.println("Login Successfull.You can proceed further.\n");

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
