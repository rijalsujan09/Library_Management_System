package library_Management_System;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BooksDaoDb implements BooksDaoInterface {
	private final static String USERNAME = "root";

	private final static String PASSWORD = "Bhbabmp1";

	private final static String URL = "jdbc:mysql://localhost:3306/books";

//----------------------------------------------------------------------------------------------------------
	// ADD Student METHOD
	@Override
	public Student addstudent(Student student) throws IOException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		String insertQuery = "INSERT INTO studentlist ( studentid ,first_name, last_name,email)" + "value ( '"
				+ student.getStudentid() + "', '" + student.getFirstname() + "', '" + student.getLastname() + "','"
				+ student.getEmail() + "')";

		System.out.println(insertQuery);

		Statement statement = con.createStatement();
		int resultValue = statement.executeUpdate(insertQuery);

		if (resultValue == 2) {
			System.out.println("Failed to insert/update data. Check your data and try again.");
		}

		statement.close();
		con.close();

		return student;
	}

//---------------------------------------------------------------------------------------------------------
	// View StudentList method
	@Override
	public void viewAllStudent() throws IOException {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from studentlist";

			// System.out.println(query);

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				System.out.println("-----------------------------------");
				System.out.println(results.getString(1));
				System.out.println(results.getString(2));
				System.out.println(results.getString(3));
				System.out.println(results.getString(4));
				System.out.println();

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

//--------------------------------------------------------------------------------------------------------
	// Add book
	@Override
	public Books addbook(Books book) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		String insertQuery = "INSERT INTO booklist (serialNo, bookName, authorName,bookquantity)" + "value ( '"
				+ book.getSerialNo() + "', '" + book.getBookName() + "','" + book.getAuthorName() + "', '"
				+ book.getBookquantity() + "')";

		System.out.println(insertQuery);

		Statement statement = con.createStatement();
		int resultValue = statement.executeUpdate(insertQuery);

		if (resultValue == 2) {
			System.out.println("Failed to insert/update data. Check your data and try again.");
		}

		statement.close();
		con.close();

		return book;
	}

//--------------------------------------------------------------------------------------------------------
	// view all books
	@Override
	public void viewbooks() throws IOException {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from booklist";

			// System.out.println(query);

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				System.out.println("----------------------------------------");
				System.out.println(results.getString(1));
				System.out.println(results.getString(2));
				System.out.println(results.getString(3));
				System.out.println(results.getString(4));
				System.out.println();

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	// ----------------------------------------------------------------------------------------------------
	// Issue books for Students

	@Override
	public Books issuedbooks(Books book) {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String insertquery = "INSERT INTO bookrecords ( studentid,issueddate,bookquantity,serialNo,expectedreturndate,returneddate)"
					+ "value ( '" + book.getstudentid() + book.getIssueddate() + book.getBookquantity()
					+ book.getSerialNo() + book.getExpectedreturndate() + book.getReturneddate() + "')";

			System.out.println(insertquery);
			statement = con.createStatement();

			int resultValue = statement.executeUpdate(insertquery);

			if (resultValue == 2) {
				System.out.println("Failed to insert/update data. Check your data and try again.");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return book;

	}

//----------------------------------------------------------------------------------------------------
//	Entry of return books
	public Books returnedbooks(Books book) {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String insertquery = "UPDATE bookrecords WHERE  studentid= "+(book).getstudentid()
					+ "value ( '" + book.getstudentid() + book.getIssueddate() + book.getBookquantity()
					+ book.getSerialNo() + book.getExpectedreturndate() + book.getReturneddate() + "')";
			
			System.out.println(insertquery);
			statement = con.createStatement();
			int resultValue = statement.executeUpdate(insertquery);

			if (resultValue == 2) {
				System.out.println("Failed to insert/update data. Check your data and try again.");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return book;

	}

	@Override
	public Books removebooks(Books book) throws ClassNotFoundException, SQLException, IOException {
		Connection con = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "DELETE FROM booklist WHERE serialNo = " + removebooks(book).getSerialNo();

			// System.out.println(query);

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {

				System.out.println(results.getString(1));
				System.out.println(results.getString(2));
				System.out.println(results.getString(3));
				System.out.println(results.getString(4));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return book;

	}

	@Override
	public Student searchbystudentid(int studentid) throws ClassNotFoundException, SQLException, IOException {
		Connection con = null;
		Statement statement = null;
		Student student = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String query = " select * from studentlist where studentid = '" + studentid + "'";

			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				student = new Student();
				student.setStudentid(results.getInt(1));

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return student;
	}

	@Override
	public Books searchbyserialNo(int serialNo) throws ClassNotFoundException, SQLException, IOException {
		Connection con = null;
		Statement statement = null;
		Books book = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String query = " select * from booklist where serialNo = '" + serialNo + "'";

			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				book = new Books();
				book.setSerialNo(results.getInt(1));

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return book;

	}

}
