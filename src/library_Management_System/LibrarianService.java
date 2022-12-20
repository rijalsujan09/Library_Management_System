package library_Management_System;

import java.io.IOException;
import java.sql.SQLException;

public class LibrarianService {
	public Student addstudent(Student student) throws ClassNotFoundException, IOException, SQLException {
		BooksDaoInterface db = new BooksDaoDb();
		db.addstudent(student);
		return student;
	}

	public Books addbook(Books book) throws ClassNotFoundException, SQLException, IOException {
		BooksDaoInterface db = new BooksDaoDb();
		db.addbook(book);
		return book;
	}
	 public void viewAllStudent() throws  ClassNotFoundException, SQLException, IOException {
		 BooksDaoInterface db = new BooksDaoDb();
			db.viewAllStudent();
			
	}
	 public void viewbooks() throws ClassNotFoundException, SQLException, IOException {
		 BooksDaoInterface db = new BooksDaoDb();
			db.viewbooks();
	}
	 public Books issuedbooks(Books book)throws ClassNotFoundException, SQLException, IOException {
		 BooksDaoInterface db = new BooksDaoDb();
			db.issuedbooks(book);
			return book;
	}
	 public Books returnedbooks(Books book)throws ClassNotFoundException, SQLException, IOException {
		 BooksDaoInterface db = new BooksDaoDb();
			db.returnedbooks(book);
			return book;
	}

	public Books removebooks(Books book)throws ClassNotFoundException, SQLException, IOException {
		 BooksDaoInterface db = new BooksDaoDb();
			db.removebooks(book);
			return book;
	}
	public boolean searchbystudentid(Student studentid) throws ClassNotFoundException, SQLException {


        BooksDaoInterface db = new BooksDaoDb();
      // Student student = null;
        try {
            db.searchbystudentid(studentid);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Some issue occurred");
            e.printStackTrace();
        }

        if (studentid == null) {
            return false;
        } else if(studentid.equals(studentid)) {
            return true;
        }
        return false;
    }
	public boolean searchbyserialNo(int serialNo) throws ClassNotFoundException, SQLException {
		
		
		

		Books book = null;
        BooksDaoInterface db = new BooksDaoDb();
      // Student student = null;
        try {
           book= db.searchbyserialNo(serialNo);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Some issue occurred");
            e.printStackTrace();
        }

        if (null== book) {
            return false;
        } else  {
            return true;
        }
    }
}

