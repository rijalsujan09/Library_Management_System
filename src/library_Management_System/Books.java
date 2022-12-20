package library_Management_System;


import java.time.LocalDate;
import java.util.Objects;

public class Books {
	private int serialNo;
	private String bookName;
	private String authorName;
	private int bookquantity;
	 private LocalDate issueddate;
	 private LocalDate returneddate;
	
	public LocalDate getReturneddate() {
		return returneddate;
	}
	public void setReturneddate(LocalDate returneddate) {
		this.returneddate = returneddate;
	}
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
	
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int serialNo, String bookName, String authorName, int bookquantity) {
		super();
		this.serialNo = serialNo;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookquantity = bookquantity;
		
	}
	public Books(int serialNo, LocalDate issueddate, LocalDate  returneddate) {
		super();
		this.serialNo = serialNo;
		this.issueddate= issueddate;
		this.returneddate= returneddate;
		
	}
	

	
	@Override
	public int hashCode() {
		return Objects.hash(authorName, bookName, bookquantity, issueddate, returneddate, serialNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		return Objects.equals(authorName, other.authorName) && Objects.equals(bookName, other.bookName)
				&& bookquantity == other.bookquantity && Objects.equals(issueddate, other.issueddate)
				&& Objects.equals(returneddate, other.returneddate) && serialNo == other.serialNo;
	}
	@Override
	public String toString() {
		return "Books [serialNo=" + serialNo + ", bookName=" + bookName + ", authorName=" + authorName
				+ ", bookquantity=" + bookquantity + ", issueddate=" + issueddate + ", returneddate=" + returneddate
				+ "]";
	}
	public String getstudentid() {
		// TODO Auto-generated method stub
		return null;
	}
	public LocalDate getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(LocalDate issueddate) {
		this.issueddate = issueddate;
	}
}
