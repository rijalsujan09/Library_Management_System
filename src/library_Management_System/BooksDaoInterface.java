package library_Management_System;

import java.io.IOException;
import java.sql.SQLException;

public interface BooksDaoInterface {
	public Books addbook(Books book) throws ClassNotFoundException, SQLException, IOException;
	 public Student addstudent(Student student) throws IOException, ClassNotFoundException, SQLException;
	 public void viewAllStudent() throws  ClassNotFoundException, SQLException, IOException;
	 public void viewbooks() throws ClassNotFoundException, SQLException, IOException;
	 public Books issuedbooks(Books book)throws ClassNotFoundException, SQLException, IOException;
	 public Books returnedbooks(Books book)throws ClassNotFoundException, SQLException, IOException;
	 public Books removebooks(Books book)throws ClassNotFoundException, SQLException, IOException;
	 public Student searchbystudentid(Student studentid)throws ClassNotFoundException, SQLException, IOException;
	 public Books searchbyserialNo(int serialNo)throws ClassNotFoundException, SQLException, IOException;
	 }


