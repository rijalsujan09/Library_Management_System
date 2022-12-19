package library_Management_System;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Librarian  {
	private int serialNo;
	private String bookName;
	private String authorName;
	private int bookquantity;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getBookquantity() {
		return bookquantity;
	}

	public void setBookquantity(int bookquantity) {
		this.bookquantity = bookquantity;
	}

	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Librarian(int serialNo, String bookName, String authorName, int bookquantity) {
		super();
		this.serialNo = serialNo;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookquantity = bookquantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorName, bookName, bookquantity, serialNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Librarian other = (Librarian) obj;
		return Objects.equals(authorName, other.authorName) && Objects.equals(bookName, other.bookName)
				&& bookquantity == other.bookquantity && serialNo == other.serialNo;

	}

	@Override
	public String toString() {
		return "Librarian [serialNo=" + serialNo + ", bookName=" + bookName + ", authorName=" + authorName
				+ ", bookquantity=" + bookquantity + "]";
	}

	

	public static void librarianfunction(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	public static void login_l(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

}
